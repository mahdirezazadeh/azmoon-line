package com.mahdi.azmoonline.manager;

import com.mahdi.azmoonline.base.entity.UserEntity;
import com.mahdi.azmoonline.config.security.JwtTokenUtil;
import com.mahdi.azmoonline.dao.UserDao;
import com.mahdi.azmoonline.service.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthenticationManagerCustom {

    private final UserDao userDao;
    private final JwtTokenUtil jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (!validateUsernameAndPassword(username, password)) {
            return ResponseEntity.status(401).build();
        }

        String token = jwtTokenUtil.generateToken(username);
        return ResponseEntity.ok(token);
    }


    public boolean validateUsernameAndPassword(String username, String password) {
        Optional<UserEntity> user = userDao.findByUsername(username);
        if (user.isEmpty()) {
            return false;
        }
        return passwordEncoder.matches(password, user.get().getPassword());
    }
}
