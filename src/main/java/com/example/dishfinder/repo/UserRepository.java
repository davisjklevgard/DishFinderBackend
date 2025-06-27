package com.example.dishfinder.repo;

import com.example.dishfinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    // You can add custom query methods later, like:
    // List<User> findByEmail(String email);
}
