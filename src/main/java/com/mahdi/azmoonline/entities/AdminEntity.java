package com.mahdi.azmoonline.entities;

import com.mahdi.azmoonline.base.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name = AdminEntity.TABLE_NAME)
public class AdminEntity extends UserEntity {
    static final String TABLE_NAME = "admin_table";
}
