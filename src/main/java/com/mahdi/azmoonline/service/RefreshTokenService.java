package com.mahdi.azmoonline.service;

import com.mahdi.azmoonline.entities.RefreshTokenEntity;

public interface RefreshTokenService {

    RefreshTokenEntity createRefreshToken(Long userId);

    void deleteRefreshToken(Long userId);
}
