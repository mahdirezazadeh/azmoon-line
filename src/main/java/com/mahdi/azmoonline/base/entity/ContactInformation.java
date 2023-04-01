package com.mahdi.azmoonline.base.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactInformation {
    private static final String EMAIL = "email";
    private static final String PHONE_NUMBER = "phone_number";

    @Column(name = EMAIL, unique = true, nullable = false)
    private String email;

    @Column(name = PHONE_NUMBER, unique = true, nullable = false)
    private String phoneNumber;
}
