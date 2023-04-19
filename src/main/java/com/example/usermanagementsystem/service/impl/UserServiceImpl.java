package com.example.usermanagementsystem.service.impl;

import com.example.usermanagementsystem.exception.UserOrRoleNotFoundException;
import com.example.usermanagementsystem.model.User;
import com.example.usermanagementsystem.repository.UserRepository;
import com.example.usermanagementsystem.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new UserOrRoleNotFoundException("User with id: " + id + " not found"));
    }

    @Override
    public User findByName(String name) {
        User user = repository.findByName(name);
        if (user == null) {
            throw new UserOrRoleNotFoundException("User with id: " + name + " not found");
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
