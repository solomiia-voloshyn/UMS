package springboot.usermanagementsystem.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springboot.usermanagementsystem.model.User;
import springboot.usermanagementsystem.repository.UserRepository;

@Service
public class UserDetailsServiceDataBase implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceDataBase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "cant find user by username: " + username));
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(user.getPassword())
                .roles(user.getRoles().toString()).build();
    }
}
