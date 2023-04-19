package com.example.usermanagementsystem.service.impl;

import com.example.usermanagementsystem.exception.UserOrRoleNotFoundException;
import com.example.usermanagementsystem.model.Role;
import com.example.usermanagementsystem.model.RoleName;
import com.example.usermanagementsystem.repository.RoleRepository;
import com.example.usermanagementsystem.service.RoleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Role findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new UserOrRoleNotFoundException("Role with id:" + id + " not found"));
    }

    @Override
    public Role findByName(RoleName name) throws UserOrRoleNotFoundException {
        Role role = repository.findByName(name);
        if (role == null) {
            throw new UserOrRoleNotFoundException("Role with name:" + name + " not found");
        }
        return role;
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }
}
