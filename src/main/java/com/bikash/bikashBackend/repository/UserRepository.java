package com.bikash.bikashBackend.repository;


import com.bikash.bikashBackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsernameAndIsActiveTrue(String username);

    User findByIdAndIsActiveTrue(Long id);

    User findByEmailAndIsActiveTrue(String email);

    int countAllByIsActiveTrue();
    int countByUsernameAndIsActiveTrue(String name);

    List<User> findAllByIsActiveTrue();
}
