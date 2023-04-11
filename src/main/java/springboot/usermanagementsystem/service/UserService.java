package springboot.usermanagementsystem.service;

import java.util.List;
import java.util.Optional;
import springboot.usermanagementsystem.model.User;

public interface UserService {
    User save(User user);

    User getById(Long id);

    List<User> getAll();

    Optional<User> findByUsername(String username);
}
