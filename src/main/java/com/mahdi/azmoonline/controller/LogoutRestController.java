package com.mahdi.azmoonline.controller;

import com.mahdi.azmoonline.service.LogoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LogoutRestController {

    private final LogoutService service;

    @PostMapping("/logout")
    public ResponseEntity logoutUser() {
        ResponseCookie cookie = service.logout();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).build();
    }
}
