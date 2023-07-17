package com.mahdi.azmoonline.service;

import com.mahdi.azmoonline.base.SelfValidating;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class LoginRequest extends SelfValidating<LoginRequest> {

    @NotBlank
    String username;
    @NotBlank
    String password;

    LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
        this.validateSelf();
    }
}