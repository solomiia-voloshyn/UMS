package springboot.usermanagementsystem.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import springboot.usermanagementsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);
}
