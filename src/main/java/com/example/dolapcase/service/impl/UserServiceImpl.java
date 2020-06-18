package com.example.dolapcase.service.impl;

import com.example.dolapcase.enums.Role;
import com.example.dolapcase.exception.exceptions.userExceptions.UserNotFoundException;
import com.example.dolapcase.model.User;
import com.example.dolapcase.repository.UserRepository;
import com.example.dolapcase.request.userRequest.AddUserRequest;
import com.example.dolapcase.request.userRequest.UpdateUserRequest;
import com.example.dolapcase.response.ApiResponse;
import com.example.dolapcase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public ResponseEntity<?> save(AddUserRequest addUserRequest) {

        if (userRepository.existsByUsername(addUserRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "username is already taken"),
                    HttpStatus.BAD_REQUEST);
        }

        User user = null;

        user.setUsername(addUserRequest.getUsername());
        user.setPassword(passwordEncoder.encode(addUserRequest.getPassword()));
        user.setEmail(addUserRequest.getEmail());
        user.setRole(Role.MEMBER);

        userRepository.save(user);

        return new ResponseEntity(new ApiResponse(true, "user saved"), HttpStatus.ACCEPTED);
    }

    @Override
    @Transactional
    public ResponseEntity<?> update(UpdateUserRequest updateUserRequest) {

        User user = new User();

        user = userRepository.findById(updateUserRequest.getId()).orElseThrow(()-> new UserNotFoundException());

        user.setUsername(updateUserRequest.getUsername());
        user.setPassword(passwordEncoder.encode(updateUserRequest.getPassword()));
        user.setEmail(updateUserRequest.getEmail());
        user.setRole(updateUserRequest.getRole());
        user.setStatus(updateUserRequest.getStatus());

        userRepository.save(user);

        return new ResponseEntity(new ApiResponse(true, "user is updated"), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {

        userRepository.findById(id).orElseThrow(()-> new UserNotFoundException());
        userRepository.deleteById(id);

        return new ResponseEntity(new ApiResponse(true, "user is deleted"), HttpStatus.ACCEPTED);
    }

    @Override
    public Page getList(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<User> page = userRepository.findAll(pageable);
        return page;
    }

}
