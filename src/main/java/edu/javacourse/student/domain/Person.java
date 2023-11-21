package edu.javacourse.student.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;
@Getter
@Setter
@Embeddable
public class Person {
    private String surName;
    private String givenName;
    private String patronymic;
    private LocalDate dateOfBirthday;
    private Address address;
}
