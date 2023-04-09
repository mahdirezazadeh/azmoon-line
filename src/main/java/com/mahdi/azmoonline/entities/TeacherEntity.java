package com.mahdi.azmoonline.entities;

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
@Table(name = TeacherEntity.TABLE_NAME)
public class TeacherEntity extends BaseEntity<Long> {
    static final String TABLE_NAME = "teacher_table";
    private static final String TEACHER_CODE = "teacher_code";

    @Column(name = TEACHER_CODE)
    private String teacherCode;
}
