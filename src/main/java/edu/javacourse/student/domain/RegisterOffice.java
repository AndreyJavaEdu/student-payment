package edu.javacourse.student.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jc_passport_office")
public class RegisterOffice {
    @Id
    @Column(name = "r_office_id")
    private Long registerOfficeId;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "r_office_area_id")
    private CountryArea countryArea;

    @Column(name = "r_office_name")
    private String registerOfficeName;
}
