package com.bikash.bikashBackend.repository;


import com.bikash.bikashBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    User findByPhoneAndIsActiveTrue(String phone);

    User findByIdAndIsActiveTrue(Long id);

    User findByEmailAndIsActiveTrue(String email);

    int countAllByIsActiveTrue();
    int countByUsernameAndIsActiveTrue(String name);

    List<User> findAllByIsActiveTrue();
}
