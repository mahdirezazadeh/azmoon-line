package com.mahdi.azmoonline.controller.dto;

import com.mahdi.azmoonline.base.SelfValidating;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class LoginRequestDto extends SelfValidating<LoginRequestDto> {

    @NotBlank
    String username;

    @NotBlank
    String password;

    LoginRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
        this.validateSelf();
    }
}