package com.example.testtask.security;

import java.util.Optional;
import com.example.testtask.model.User;
import com.example.testtask.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByName(username);

        org.springframework.security.core.userdetails.User.UserBuilder builder;
        if (userOptional.isPresent()) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(userOptional.get().getPassword());
            builder.roles("");
            return builder.build();
        }
        throw new UsernameNotFoundException("User not found.");
    }
}
