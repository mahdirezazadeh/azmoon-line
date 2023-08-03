package com.mahdi.azmoonline.controller;

import com.mahdi.azmoonline.controller.dto.SignupRequestDto;
import com.mahdi.azmoonline.service.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guest")
public class UserRegisterRestController {

    private final RegisterService service;

    @PostMapping("/register-teacher")
    public ResponseEntity<Long> registerTeacher(@Valid @RequestBody SignupRequestDto dto) {
        Long teacherId = service.registerTeacher(dto);
        return ResponseEntity.ok(teacherId);
    }

    @PostMapping("/register-student")
    public ResponseEntity<Long> registerStudent(@Valid @RequestBody SignupRequestDto dto) {
        Long studentId = service.registerStudent(dto);
        return ResponseEntity.ok(studentId);
    }
}