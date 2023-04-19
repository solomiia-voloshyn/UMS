package com.example.usermanagementsystem.dto.request;

import com.example.usermanagementsystem.lib.ValidPassword;
import com.example.usermanagementsystem.lib.ValidRolesSet;
import com.example.usermanagementsystem.lib.ValidStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {
    @NotBlank(message = "name must not be blank")
    @Size(min = 3, max = 16, message = "name size must be from 3 to 16 symbols")
    @Pattern(regexp = "[a-zA-Z]+", message = "name must contains only latin letters")
    private String name;
    @ValidPassword(message = "The password is not valid. "
            + "Password must contains 3-16 symbols, "
            + "min 1 character and min 1 number")
    private String password;
    @NotBlank(message = "Firstname must not be blank")
    @Size(min = 1, max = 16, message = "size firstname must be 1-16 symbols")
    @Pattern(regexp = "[a-zA-Z]+", message = "Firstname must contains only latin letters")
    private String firstName;
    @Size(min = 1, max = 16, message = "Size lastname must be 1-16 symbols")
    @Pattern(regexp = "[a-zA-Z]+", message = "Lastname must contains only latin letters")
    private String lastName;
    @ValidRolesSet(message = "should have set id of existed roles")
    private String role;
    @ValidStatus(message = "only ACTIVE or INACTIVE")
    private String status;
}
