package com.mahdi.azmoonline.base.entity;

import com.mahdi.azmoonline.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = OperationEntity.TABLE_NAME)
public class OperationEntity extends BaseEntity<Integer> {
    static final String TABLE_NAME = "operation_table";
    private static final String NAME = "name";

    @Column(name = NAME)
    private String name;
}
