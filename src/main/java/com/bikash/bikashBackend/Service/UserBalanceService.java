package com.bikash.bikashBackend.Service;

import com.bikash.bikashBackend.Model.UserBalance;

public interface UserBalanceService {
    UserBalance create(Long userId,double balance);
}
