package edu.javacourse.student.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "jc_student_child")
@AssociationOverrides({
        @AssociationOverride(name = "address.street", joinColumns = @JoinColumn(name = "с_street_code"))
})
@AttributeOverrides({
        @AttributeOverride(name = "surName", column = @Column(name = "с_surname")),
        @AttributeOverride(name = "givenName", column = @Column(name = "с_gсiven_name")),
        @AttributeOverride(name = "patronymic", column = @Column(name = "с_patronomyc")),
        @AttributeOverride(name = "dateOfBirthday", column = @Column(name = "с_date_of_birth")),
        @AttributeOverride(name = "address.postCode", column = @Column(name = "с_post_index")),
        @AttributeOverride(name = "address.building", column = @Column(name = "с_building")),
        @AttributeOverride(name = "address.extension", column = @Column(name = "с_extension")),
        @AttributeOverride(name = "address.apartment", column = @Column(name = "с_apartment"))
})
public class StudentOrderChild extends Person {
    @Id
    @Column(name = "student_child_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentOrderChildId;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_order_id")
    private StudentOrder studentOrder;

    @Column(name = "с_certificate_number")
    private String certificateNumber;

    @Column(name = "с_certificate_date")
    private LocalDate certificateDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "с_register_office_id")
    private RegisterOffice registerOffice;

}
