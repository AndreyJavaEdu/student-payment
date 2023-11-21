package edu.javacourse.student.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jc_passport_office")
public class PassportOffice {
    @Id
    @Column(name = "p_office_id")
    private Long passportOfficeId;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "p_office_area_id")
    private CountryArea countryArea;

    @Column(name = "p_office_name")
    private String passportOfficeName;
}
