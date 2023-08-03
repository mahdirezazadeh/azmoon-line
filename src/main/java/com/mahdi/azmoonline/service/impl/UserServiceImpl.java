package com.mahdi.azmoonline.service.impl;

import com.mahdi.azmoonline.base.entity.UserEntity;
import com.mahdi.azmoonline.base.service.impl.BaseServiceImpl;
import com.mahdi.azmoonline.dao.UserDao;
import com.mahdi.azmoonline.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, Long, UserDao> implements UserService {

    public UserServiceImpl(UserDao dao) {
        super(dao);
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }
}
