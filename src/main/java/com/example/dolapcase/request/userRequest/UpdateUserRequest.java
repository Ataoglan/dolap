package com.example.dolapcase.request.userRequest;


import com.example.dolapcase.enums.Role;
import com.example.dolapcase.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest extends BaseUserRequest {
    private Long id;
    private Role role;
    private UserStatus status;
}
