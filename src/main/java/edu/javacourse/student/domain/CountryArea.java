package edu.javacourse.student.domain;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "jc_country_struct")
public class CountryArea {
    @Id
    @Column(name = "area_id")
    private String areaId;
    @Column(name = "area_name")
    private String areaName;

}
