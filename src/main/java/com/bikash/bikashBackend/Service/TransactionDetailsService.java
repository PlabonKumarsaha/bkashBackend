package com.bikash.bikashBackend.Service;

import com.bikash.bikashBackend.Model.TransactionDetails;

public interface TransactionDetailsService {
    TransactionDetails create(Long transactionId,Long userId,double openingBalance);
}
