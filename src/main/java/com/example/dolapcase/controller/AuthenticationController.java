package com.example.dolapcase.controller;

import com.example.dolapcase.request.authenticationRequest.LoginRequest;
import com.example.dolapcase.request.userRequest.AddUserRequest;
import com.example.dolapcase.response.ApiResponse;
import com.example.dolapcase.response.AuthenticationResponse;
import com.example.dolapcase.security.CustomUserDetailsService;
import com.example.dolapcase.security.JwtTokenProvider;
import com.example.dolapcase.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder;

    private CustomUserDetailsService userDetailsService;

    private UserServiceImpl userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider,
                                    PasswordEncoder passwordEncoder, CustomUserDetailsService userDetailsService,
                                    UserServiceImpl userService){
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getUsername());

        String jwt = tokenProvider.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AddUserRequest signUpRequest) {

        userService.save(signUpRequest);

        return new ResponseEntity(new ApiResponse(true, "User registered successfully"), HttpStatus.CREATED);
    }
}
