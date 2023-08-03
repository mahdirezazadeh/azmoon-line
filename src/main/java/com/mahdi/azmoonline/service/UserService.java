package com.mahdi.azmoonline.service;

import com.mahdi.azmoonline.base.entity.UserEntity;
import com.mahdi.azmoonline.base.service.BaseService;

import java.util.Optional;

public interface UserService extends BaseService<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    boolean existsByUsername(String username);
}
