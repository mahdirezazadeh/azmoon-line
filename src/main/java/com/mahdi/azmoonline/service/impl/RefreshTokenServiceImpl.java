package com.mahdi.azmoonline.service.impl;

import com.mahdi.azmoonline.base.entity.UserEntity;
import com.mahdi.azmoonline.dao.RefreshTokenDao;
import com.mahdi.azmoonline.dao.UserDao;
import com.mahdi.azmoonline.entities.RefreshTokenEntity;
import com.mahdi.azmoonline.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenDao dao;
    private final UserDao userDao;

    @Value("${app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    @Override
    @Transactional
    public RefreshTokenEntity createRefreshToken(Long userId) {
        RefreshTokenEntity refreshToken = new RefreshTokenEntity();

        refreshToken.setUser(userDao.findById(userId).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = dao.save(refreshToken);
        return refreshToken;
    }

    @Override
    @Transactional
    public void deleteRefreshToken(Long userId) {
        UserEntity userEntity = userDao.findById(userId).get();
        dao.deleteByUser(userEntity);
    }
}
