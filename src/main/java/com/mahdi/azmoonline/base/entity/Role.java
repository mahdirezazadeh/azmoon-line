package com.mahdi.azmoonline.base.entity;

import com.mahdi.azmoonline.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = Role.TABLE_NAME)
public class Role extends BaseEntity<Integer> {
    static final String TABLE_NAME = "role_table";
    private static final String NAME = "name";

    @Column(name = NAME)
    private String name;

    @ManyToMany
    @Builder.Default
    private Set<Operation> operations = new HashSet<>();

}
