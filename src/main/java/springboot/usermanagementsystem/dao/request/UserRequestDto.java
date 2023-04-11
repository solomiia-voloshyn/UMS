package springboot.usermanagementsystem.dao.request;

import jakarta.validation.constraints.Pattern;
import java.util.List;
import lombok.Data;

@Data
public class UserRequestDto {
    private static final String PATTERN_ONLY_LETTERS = "^[A-Za-z]+$";
    private static final String PATTERN_PASSWORD
            = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).+$";

    @Pattern(regexp = PATTERN_ONLY_LETTERS)
    private String firstName;
    @Pattern(regexp = PATTERN_ONLY_LETTERS)
    private String lastName;
    @Pattern(regexp = PATTERN_ONLY_LETTERS)
    private String username;
    @Pattern(regexp = PATTERN_PASSWORD)
    private String password;
    private String status;
    private List<String> userRole;
}
