package com.mahdi.azmoonline.dao;

import com.mahdi.azmoonline.base.entity.UserEntity;
import com.mahdi.azmoonline.entities.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenDao extends JpaRepository<RefreshTokenEntity, Long> {

    Optional<RefreshTokenEntity> findByToken(String token);

    int deleteByUser(UserEntity userEntity);
}
