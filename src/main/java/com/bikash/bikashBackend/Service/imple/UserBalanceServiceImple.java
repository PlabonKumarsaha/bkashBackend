package com.bikash.bikashBackend.Service.imple;

import com.bikash.bikashBackend.Model.UserBalance;
import com.bikash.bikashBackend.Service.UserBalanceService;
import com.bikash.bikashBackend.repository.UserBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userBalanceService")
public class UserBalanceServiceImple implements UserBalanceService {
    private final UserBalanceRepository userBalanceRepository;

    @Autowired
    public UserBalanceServiceImple(UserBalanceRepository userBalanceRepository) {
        this.userBalanceRepository = userBalanceRepository;
    }

    @Override
    public UserBalance create(Long userId, double balance) {
        if (balance == 0) {

        }
        UserBalance userBalance = new UserBalance();
        userBalance.setUserId(userId);
        userBalance.setBalance(balance);
        userBalance = userBalanceRepository.save(userBalance);
        if (userBalance != null) {
            return userBalance;
        }
        return null;
    }
}
