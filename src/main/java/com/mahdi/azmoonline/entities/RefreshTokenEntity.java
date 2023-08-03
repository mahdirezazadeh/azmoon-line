package com.mahdi.azmoonline.entities;

import com.mahdi.azmoonline.base.BaseEntity;
import com.mahdi.azmoonline.base.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "refresh_token", schema = "digital_wallet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenEntity extends BaseEntity<Long> {

    @OneToOne
    @JoinColumn(name = "id")
    private UserEntity user;

    @Column(nullable = false, unique = true, length = 64)
    private String token;

    @Column(nullable = false)
    private Instant expiryDate;
}
