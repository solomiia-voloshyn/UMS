package springboot.usermanagementsystem.service;

import springboot.usermanagementsystem.model.UserRole;

public interface UserRoleService {
    UserRole getById(Long id);

    UserRole getByName(String role);
}
