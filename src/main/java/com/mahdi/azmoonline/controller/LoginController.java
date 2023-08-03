package com.mahdi.azmoonline.controller;

import com.mahdi.azmoonline.controller.dto.LoginRequestDto;
import com.mahdi.azmoonline.manager.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest")
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity authenticateUser(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        LoginService.Response response =
                loginService.login(new LoginService.Param(loginRequestDto.getUsername(), loginRequestDto.getPassword()));
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, response.jwtCookie())
                .header(HttpHeaders.SET_COOKIE, response.jwtRefreshCookie()).build();
    }
}
