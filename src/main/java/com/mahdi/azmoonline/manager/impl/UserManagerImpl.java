package com.mahdi.azmoonline.manager.impl;

import com.mahdi.azmoonline.base.entity.UserEntity;
import com.mahdi.azmoonline.base.manager.impl.BaseManagerImpl;
import com.mahdi.azmoonline.dao.UserDao;
import com.mahdi.azmoonline.manager.UserManager;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserManagerImpl extends BaseManagerImpl<UserEntity, Long, UserDao> implements UserManager {

    public UserManagerImpl(UserDao repository) {
        super(repository);
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
