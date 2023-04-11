package springboot.usermanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(authorizeRequests -> {
                    authorizeRequests
                            .antMatchers(HttpMethod.GET, "/user")
                            .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                            .antMatchers(HttpMethod.GET, "/user/{id}")
                            .hasAnyAuthority("ROLE_ADMIN")
                            .antMatchers(HttpMethod.POST, "/user/new")
                            .hasAnyAuthority("ROLE_ADMIN")
                            .antMatchers(HttpMethod.GET, "/user/{id}/edit")
                            .hasAnyAuthority("ROLE_ADMIN")
                            .antMatchers("/**").permitAll();
                })
                .httpBasic()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .csrf().disable()
                .build();
    }
}
