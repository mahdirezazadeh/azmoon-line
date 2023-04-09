package com.mahdi.azmoonline.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mahdi.azmoonline.base.entity.UserEntity;
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
@Table(name = StudentEntity.TABLE_NAME)
public class StudentEntity extends UserEntity {
    static final String TABLE_NAME = "student_table";


    @ManyToMany(mappedBy = "students")
    @Builder.Default
    @JsonIgnore
    private Set<CourseEntity> courses = new HashSet<>();
}
