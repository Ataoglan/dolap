package com.example.dolapcase.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public AuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

}
