package com.example.usermanagementsystem.security;

import com.example.usermanagementsystem.exception.UserOrRoleNotFoundException;
import com.example.usermanagementsystem.model.Status;
import com.example.usermanagementsystem.model.User;
import com.example.usermanagementsystem.service.UserService;
import javax.naming.AuthenticationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User login(String login, String password) throws AuthenticationException {
        User user;
        try {
            user = userService.findByName(login);
        } catch (UserOrRoleNotFoundException e) {
            throw new AuthenticationException("Incorrect user or password");
        }
        if (passwordEncoder.matches(password, user.getPassword())
                && user.getStatus() == Status.ACTIVE) {
            return user;
        }
        throw new AuthenticationException("Incorrect user or password");
    }
}
