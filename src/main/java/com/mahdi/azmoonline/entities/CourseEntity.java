package com.mahdi.azmoonline.entities;

import com.mahdi.azmoonline.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = CourseEntity.TABLE_NAME)
public class CourseEntity extends BaseEntity<Long> {
    static final String TABLE_NAME = "course_table";
    private static final String TITLE = "title";
    private static final String START_DATE = "start_date";
    private static final String END_DATE = "end_date";

    @Column(name = TITLE)
    private String title;

    @Column(name = START_DATE)
    private Date startDate;

    @Column(name = END_DATE)
    private Date endDate;

    @ManyToOne
    private TeacherEntity teacher;

    @ManyToMany
    @Builder.Default
    private Set<StudentEntity> students = new HashSet<>();
}
