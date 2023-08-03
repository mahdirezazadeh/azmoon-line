package com.mahdi.azmoonline.service;

import com.mahdi.azmoonline.controller.dto.SignupRequestDto;

public interface RegisterService {

    Long registerStudent(SignupRequestDto dto);

    Long registerTeacher(SignupRequestDto dto);
}
