package com.mahdi.azmoonline.manager;

import com.mahdi.azmoonline.base.entity.UserEntity;
import com.mahdi.azmoonline.base.manager.BaseManager;

import java.util.Optional;

public interface UserManager extends BaseManager<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}
