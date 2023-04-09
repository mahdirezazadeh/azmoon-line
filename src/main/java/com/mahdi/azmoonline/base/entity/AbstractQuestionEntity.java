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
@Table(name = AbstractQuestionEntity.TABLE_NAME)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractQuestionEntity extends BaseEntity<Long> {
    static final String TABLE_NAME = "question_table";

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    private AbstractAnswerEntity answer;
}
