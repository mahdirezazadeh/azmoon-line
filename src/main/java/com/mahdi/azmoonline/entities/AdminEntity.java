package com.mahdi.azmoonline.entities;

import com.mahdi.azmoonline.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = AdminEntity.TABLE_NAME)
public class AdminEntity extends BaseEntity<Long> {
    static final String TABLE_NAME = "admin_table";
}
