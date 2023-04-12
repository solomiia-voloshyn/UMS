package springboot.usermanagementsystem.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import springboot.usermanagementsystem.dao.mapper.UserMapper;
import springboot.usermanagementsystem.dao.request.UserRequestDto;
import springboot.usermanagementsystem.dao.response.UserResponseDto;
import springboot.usermanagementsystem.model.Status;
import springboot.usermanagementsystem.model.User;
import springboot.usermanagementsystem.model.UserRole;
import springboot.usermanagementsystem.service.UserRoleService;

import java.util.ArrayList;

@SpringBootTest
@AutoConfigureMockMvc
class UserMapperTest {
    @MockBean
    private UserRoleService userRoleService;

    @Autowired
    private UserMapper userMapper;

    @Test
    void shouldReturnUser() {
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setFirstName("FirstName");
        userRequestDto.setLastName("LastName");
        userRequestDto.setUsername("Username");
        userRequestDto.setPassword("afds2Dsd/");
        userRequestDto.setStatus("ACTIVE");

        if (userRequestDto.getUserRole() == null) {
            userRequestDto.setUserRole(new ArrayList<String>());
        }
        userRequestDto.getUserRole().add("ADMIN");

        UserRole admin = new UserRole();
        admin.setId(1L);
        admin.setRole("ADMIN");
        Mockito.when(userRoleService.getByName("ADMIN")).thenReturn(admin);

        User expected = new User();
        expected.setFirstName("FirstName");
        expected.setLastName("LastName");
        expected.setUsername("Username");
        expected.getRoles().add(admin);
        expected.setPassword("afds2Dsd/");
        expected.setStatus(Status.ACTIVE);

        User actual = userMapper.toModel(userRequestDto);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void shouldReturnUserResponseDto() {
        UserRole admin = new UserRole();
        admin.setId(1L);
        admin.setRole("ADMIN");

        User user = new User();
        user.setId(1L);
        user.setFirstName("FirstName");
        user.setLastName("LastName");
        user.setUsername("Username");
        user.getRoles().add(admin);
        user.setPassword("afds2Dsd/");
        user.setStatus(Status.ACTIVE);

        UserResponseDto expected = new UserResponseDto();
        expected.setId(1L);
        expected.setFirstName("FirstName");
        expected.setLastName("LastName");
        expected.setUserRole(new ArrayList<>());
        expected.getUserRole().add("ADMIN");
        expected.setStatus("ACTIVE");

        UserResponseDto actual = userMapper.toResponseDto(user);
        Assertions.assertEquals(actual, expected);
    }
}
