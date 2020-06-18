package com.example.dolapcase.security;

import com.example.dolapcase.model.User;
import com.example.dolapcase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("username is not found" + username)
        );

        UserDetails userDetails = createUser(user);

        return userDetails;

    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("id is not found: " + id)
        );

        UserDetails userDetails = createUser(user);

        return userDetails;
    }

    private UserDetails createUser(User user){
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        builder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
        builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
        builder.roles(user.getRole().toString());

        return builder.build();
    }
}
