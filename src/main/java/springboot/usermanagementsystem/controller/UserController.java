package springboot.usermanagementsystem.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.usermanagementsystem.dao.mapper.UserMapper;
import springboot.usermanagementsystem.dao.request.UserRequestDto;
import springboot.usermanagementsystem.dao.response.UserResponseDto;
import springboot.usermanagementsystem.model.User;
import springboot.usermanagementsystem.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService,
                          UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    List<UserResponseDto> getAll() {
        return userService.getAll().stream()
                .map(userMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    UserResponseDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toResponseDto(user);
    }

    @PostMapping
    UserResponseDto create(@RequestBody @Valid UserRequestDto userRequestDto) {
        return userMapper.toResponseDto(
                userService.save(
                        userMapper.toModel(userRequestDto)));
    }

    @PostMapping("/{id}")
    UserResponseDto update(@PathVariable Long id,
                           @RequestBody @Valid UserRequestDto userRequestDto) {
        User user = userMapper.toModel(userRequestDto);
        user.setId(id);
        return userMapper.toResponseDto(userService.save(user));

    }
}
