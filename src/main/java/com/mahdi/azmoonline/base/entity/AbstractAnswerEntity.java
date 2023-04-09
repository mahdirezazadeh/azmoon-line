package com.mahdi.azmoonline.base.entity;

import com.mahdi.azmoonline.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = AbstractAnswerEntity.TABLE_NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbstractAnswerEntity extends BaseEntity<Long> {
    static final String TABLE_NAME = "answer_table";

    @OneToOne(optional = false)
    @JoinColumn
    private AbstractQuestionEntity question;
}
