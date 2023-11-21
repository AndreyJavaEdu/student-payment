package edu.javacourse.student.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
@Getter
@Setter
@Embeddable
public class Adult extends Person {
    private String passportSerial;
    private String passportNumber;
    private LocalDate issueDate;
}
