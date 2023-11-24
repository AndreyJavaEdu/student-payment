package edu.javacourse.student.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@Embeddable
public class Adult extends Person {
    private String passportSerial;
    private String passportNumber;
    private LocalDate issueDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private PassportOffice passportOffice;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private University university;

    private String studentNumber;



}
