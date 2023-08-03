package com.mahdi.azmoonline.controller.dto;

import com.mahdi.azmoonline.base.SelfValidating;
import lombok.Value;

@Value
public class SignupRequestDto extends SelfValidating<SignupRequestDto> {

    String username;
    String email;
    String phoneNumber;
    String password;
    String confirmPassword;
    String firstName;
    String lastName;

    public SignupRequestDto(String username, String email, String phoneNumber, String password, String confirmPassword, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.validateSelf();
    }
}
