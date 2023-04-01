package com.mahdi.azmoonline.base.entity;

import com.mahdi.azmoonline.base.BaseEntity;
import com.mahdi.azmoonline.base.entity.enumeration.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = User.TABLE_NAME)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User extends BaseEntity<Long> {
    static final String TABLE_NAME = "user_table";
    private static final String GENDER = "gender";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "first_name";
    private static final String LASTNAME = "lastname";
    private static final String BIRTHDAY = "birthday";
    private static final String NATIONAL_CODE = "national_code";
    private static final String IS_ACTIVE = "is_active";
    private static final String IS_CONFIRMED = "is_confirmed";


    @Column(name = USERNAME, unique = true, nullable = false)
    private String username;

    @Column(name = PASSWORD, nullable = false)
    private String password;

    @Column(name = FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = LASTNAME, nullable = false)
    private String lastName;

    @Column(name = BIRTHDAY)
    private Date birthday;

    @Column(name = NATIONAL_CODE)
    private String nationalCode;

    @Column(name = GENDER)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = IS_ACTIVE)
    private boolean isActive = true;

    @Column(name = IS_CONFIRMED)
    private boolean isConfirmed = false;

    @Embedded
    private ContactInformation contactInformation;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    public String getFullName() {
        return firstName.concat(" ").concat(lastName);
    }
}
