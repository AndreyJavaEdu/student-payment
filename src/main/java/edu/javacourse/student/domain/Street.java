package edu.javacourse.student.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "jc_street")
public class Street {
    @Id
    @Column(name = "street_code")
    private Long streetCode;
    @Column(name = "street_name")
    private String streetName;
}
