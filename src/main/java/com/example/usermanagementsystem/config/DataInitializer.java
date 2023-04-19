package com.example.usermanagementsystem.config;

import com.example.usermanagementsystem.exception.UserOrRoleNotFoundException;
import com.example.usermanagementsystem.model.Role;
import com.example.usermanagementsystem.model.RoleName;
import com.example.usermanagementsystem.model.Status;
import com.example.usermanagementsystem.model.User;
import com.example.usermanagementsystem.service.RoleService;
import com.example.usermanagementsystem.service.UserService;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private static final String ADMIN_LOGIN = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String ADMIN_FIRSTNAME = "Ivan";
    private static final String ADMIN_LASTNAME = "Ivanov";
    private static final String USER_FIRSTNAME = "Pety";
    private static final String USER_LASTNAME = "Petrov";
    private static final String USER_LOGIN = "user";
    private static final String USER_PASSWORD = "user123";
    private final RoleService roleService;
    private final UserService userService;

    @PostConstruct
    public void dataInit() {
        Role adminRole = roleService.findByName(RoleName.ADMIN);
        Role userRole = roleService.findByName(RoleName.USER);
        try {
            userService.findByName(ADMIN_LOGIN);
        } catch (UserOrRoleNotFoundException e) {
            User adminUser = new User();
            adminUser.setName(ADMIN_LOGIN);
            adminUser.setPassword(ADMIN_PASSWORD);
            adminUser.setFirstName(ADMIN_FIRSTNAME);
            adminUser.setLastName(ADMIN_LASTNAME);
            adminUser.setStatus(Status.ACTIVE);
            adminUser.setRole(roleService.findByName(RoleName.ADMIN));
            userService.save(adminUser);
        }
        try {
            userService.findByName(USER_LOGIN);
        } catch (UserOrRoleNotFoundException e) {
            User userUser = new User();
            userUser.setName(USER_LOGIN);
            userUser.setPassword(USER_PASSWORD);
            userUser.setFirstName(USER_FIRSTNAME);
            userUser.setLastName(USER_LASTNAME);
            userUser.setStatus(Status.ACTIVE);
            userUser.setRole(roleService.findByName(RoleName.USER));
            userService.save(userUser);
        }
    }
}
