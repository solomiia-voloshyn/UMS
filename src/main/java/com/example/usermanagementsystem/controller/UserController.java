package com.example.usermanagementsystem.controller;

import com.example.usermanagementsystem.dto.mapper.RequestDtoMapper;
import com.example.usermanagementsystem.dto.mapper.ResponseDtoMapper;
import com.example.usermanagementsystem.dto.request.UserRequestDto;
import com.example.usermanagementsystem.dto.response.UserResponseDto;
import com.example.usermanagementsystem.exception.UserOrRoleNotFoundException;
import com.example.usermanagementsystem.model.User;
import com.example.usermanagementsystem.service.UserService;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final RequestDtoMapper<UserRequestDto, User> userRequestDtoMapper;
    private final ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper;

    @GetMapping
    @ApiOperation(value = "Get list of all users")
    public List<UserResponseDto> findAll() {
        return userService.findAll().stream()
                .map(userResponseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get information about user by id")
    public UserResponseDto findUserById(@PathVariable Long id) {
        return userResponseDtoMapper.toDto(userService.findById(id));
    }

    @PostMapping
    @ApiOperation(value = "Create new user")
    public UserResponseDto createUser(@RequestBody @Valid UserRequestDto dto) {
        User user = userRequestDtoMapper.toModel(dto);
        return userResponseDtoMapper.toDto(userService.save(user));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update information about user")
    public UserResponseDto updateUser(
            @RequestBody @Valid UserRequestDto dto,
            @PathVariable Long id) {
        try {
            userService.findById(id);
        } catch (UserOrRoleNotFoundException e) {
            throw new UserOrRoleNotFoundException("User with if: " + id + " for update not found");
        }
        User user = userRequestDtoMapper.toModel(dto);
        user.setId(id);
        return userResponseDtoMapper.toDto(userService.save(user));
    }
}
