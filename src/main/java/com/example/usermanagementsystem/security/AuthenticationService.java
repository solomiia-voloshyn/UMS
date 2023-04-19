package com.example.usermanagementsystem.security;

import com.example.usermanagementsystem.model.User;
import javax.naming.AuthenticationException;

public interface AuthenticationService {

    User login(String login, String password) throws AuthenticationException;
}
