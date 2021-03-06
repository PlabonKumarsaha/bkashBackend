package com.bikash.bikashBackend.Service.imple;

import com.bikash.bikashBackend.Model.Transactions;
import com.bikash.bikashBackend.Service.TransactionService;
import com.bikash.bikashBackend.repository.TransactionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("transactionService")
public class TransactionServiceImple implements TransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImple.class);
    private final TransactionsRepository transactionsRepository;

    @Autowired
    public TransactionServiceImple(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @Override
    public Transactions create(Long userId, double openingBalance, double transactionAmount, Date date) {
        if (openingBalance == 0) {
            //this is not a account opening time Transaction..This is another time Transaction
            Transactions transactions = setTransaction("orderTransactions", date, transactionAmount, userId);
            if (transactions != null) {
                return transactions;
            }
            return null;
        }
        Transactions transactions = setTransaction("OpeningTransactions", date, openingBalance, userId);
        if (transactions != null) {
            return transactions;
        }
        return null;
    }

    private Transactions setTransaction(String transactionsRef, Date date, double transactionAmount, Long userId) {
        Transactions transactions = new Transactions();
        transactions.setTransactionRef(transactionsRef);
        transactions.setTransactionDate(date);
        transactions.setTransactionAmount(transactionAmount);
        transactions.setUserId(userId);
        transactions = transactionsRepository.save(transactions);
        if (transactions != null) {
            Transactions currentTransaction = transactionsRepository.findByIdAndIsActiveTrue(transactions.getId());
            if (currentTransaction != null) {
                Long timestamp = System.currentTimeMillis();
                String uniqueTransactionId = String.valueOf(timestamp).concat(userId.toString());
                currentTransaction.setTransactionId(Long.parseLong(uniqueTransactionId));
                currentTransaction = transactionsRepository.save(currentTransaction);//update currentTransaction for set unique Transaction id
                if (currentTransaction != null) {
                    return currentTransaction;
                }
            }
        }
        return null;
    }
}
