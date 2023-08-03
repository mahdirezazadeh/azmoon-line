package com.mahdi.azmoonline.service;

public interface LoginService {

    Response login(Param param);

    record Param(String username, String password) {
    }

    record Response(String jwtCookie, String jwtRefreshCookie) {
    }
}
