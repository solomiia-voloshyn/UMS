package com.example.usermanagementsystem.controller;

import com.example.usermanagementsystem.dto.mapper.ResponseDtoMapper;
import com.example.usermanagementsystem.dto.response.RoleResponseDto;
import com.example.usermanagementsystem.model.Role;
import com.example.usermanagementsystem.service.RoleService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    private final ResponseDtoMapper<RoleResponseDto, Role> roleResponseDtoMapper;

    @GetMapping
    @ApiOperation(value = "Get list all roles")
    public List<RoleResponseDto> findAll() {
        return roleService.findAll().stream()
                .map(roleResponseDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
