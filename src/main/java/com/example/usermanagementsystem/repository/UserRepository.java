package com.example.usermanagementsystem.repository;

import com.example.usermanagementsystem.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    User findByName(String name);
}
