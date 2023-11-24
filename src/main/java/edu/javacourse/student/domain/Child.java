package edu.javacourse.student.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Embeddable
public class Child extends Person{
    private String certificateNumber;

    private LocalDate certificateDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private RegisterOffice registerOffice;
}
