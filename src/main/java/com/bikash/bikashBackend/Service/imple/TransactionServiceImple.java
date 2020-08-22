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
            //transactions
        }
        Transactions transactions = new Transactions();
        transactions.setTransactionRef("openingBalance");
        transactions.setTransactionDate(date);
        transactions.setTransactionAmount(openingBalance);
        transactions.setUserId(userId);
        transactions = transactionsRepository.save(transactions);
        if (transactions != null) {
           Transactions transactions2 = transactionsRepository.findByIdAndIsActiveTrue(transactions.getId());
            if (transactions2!=null){
                Long timestamp = System.currentTimeMillis();
                String newId = String.valueOf(timestamp).concat(userId.toString());
                transactions2.setTransactionId(Long.parseLong(newId));
                try {
                    transactions2=  transactionsRepository.save(transactions2);
                    if (transactions2!=null){
                        return transactions2;
                    }
                }catch (Exception e){
                 logger.info("ERROR is :  "+e.getMessage());
                }
                //transactions2=  transactionsRepository.save(transactions2);

            }

        }
        return null;
    }
}
