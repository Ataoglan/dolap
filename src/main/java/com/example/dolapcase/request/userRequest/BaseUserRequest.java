package com.example.dolapcase.request.userRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseUserRequest {
    private String username;
    private String password;
    private String email;
}
