package com.mahdi.azmoonline.service.impl;

import com.mahdi.azmoonline.base.entity.UserEntity;
import com.mahdi.azmoonline.config.security.SecurityUser;
import com.mahdi.azmoonline.controller.dto.SignupRequestDto;
import com.mahdi.azmoonline.entities.RefreshTokenEntity;
import com.mahdi.azmoonline.entities.StudentEntity;
import com.mahdi.azmoonline.entities.TeacherEntity;
import com.mahdi.azmoonline.service.*;
import com.mahdi.azmoonline.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements LoginService, LogoutService, RegisterService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;
    private final JwtUtils jwtUtils;

    @Override
    public Response login(Param param) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(param.username(), param.password()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        SecurityUser userDetails = (SecurityUser) authentication.getPrincipal();
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
        RefreshTokenEntity refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
        ResponseCookie jwtRefreshCookie = jwtUtils.generateRefreshJwtCookie(refreshToken.getToken());
        return new Response(jwtCookie.toString(), jwtRefreshCookie.toString());
    }

    @Override
    public ResponseCookie logout() {
        SecurityUser userDetail = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        refreshTokenService.deleteRefreshToken(userDetail.getId());
        return jwtUtils.getCleanJwtCookie();
    }

    @Override
    public Long registerStudent(SignupRequestDto dto) {
        validateDto(dto);
        StudentEntity studentEntity = new StudentEntity();
        copyDtoToEntity(studentEntity, dto);
        return userService.save(studentEntity).getId();
    }

    @Override
    public Long registerTeacher(SignupRequestDto dto) {
        validateDto(dto);
        TeacherEntity teacherEntity = new TeacherEntity();
        copyDtoToEntity(teacherEntity, dto);
        return userService.save(teacherEntity).getId();
    }

    private void validateDto(SignupRequestDto dto) {
        if (userService.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username is already taken!");
        }
        if (!Objects.equals(dto.getPassword(), dto.getConfirmPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password and repeat not matched");
        }
    }

    private void copyDtoToEntity(UserEntity entity, SignupRequestDto dto) {
        entity.setUsername(dto.getUsername());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.getContactInformation().setEmail(dto.getEmail());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.getContactInformation().setPhoneNumber(dto.getPhoneNumber());
    }
}
