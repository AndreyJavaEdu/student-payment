package edu.javacourse.student.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
@Getter
@Setter
public class Address {
    private String postCode;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Street street;
    private String building;
    private String extension; //корпус
    private String apartment; //апартаменты
}
