package springboot.usermanagementsystem.service.impl;

import org.springframework.stereotype.Service;
import springboot.usermanagementsystem.model.UserRole;
import springboot.usermanagementsystem.repository.UserRoleRepository;
import springboot.usermanagementsystem.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole getById(Long id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find role by id: " + id));
    }

    @Override
    public UserRole getByName(String role) {
        return userRoleRepository.findUserRoleByRole(role)
                .orElseThrow(() -> new RuntimeException("Can't find role by role name: " + role));
    }
}
