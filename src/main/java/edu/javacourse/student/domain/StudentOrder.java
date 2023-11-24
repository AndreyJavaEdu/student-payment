package edu.javacourse.student.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "jc_student_order")
public class StudentOrder {
    @Id
    @Column(name = "student_order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentOrderId;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_order_status_id")
    private StudentOrderStatus studentOrderStatus;
    @Column(name = "student_order_date")
    private LocalDate studentOrderDate;

    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.REMOVE}, fetch = FetchType.LAZY,
    mappedBy = "studentOrder")
    private List<StudentOrderChild> children;

    @AssociationOverrides({
            @AssociationOverride(name = "address.street", joinColumns = @JoinColumn(name = "w_street_code")),
            @AssociationOverride(name = "passportOffice", joinColumns = @JoinColumn(name = "w_passport_office_id")),
            @AssociationOverride(name = "university", joinColumns = @JoinColumn(name = "w_university_id"))
    })
    @AttributeOverrides({
            @AttributeOverride(name = "surName", column = @Column(name = "w_surname")),
            @AttributeOverride(name = "givenName", column = @Column(name = "w_given_name")),
            @AttributeOverride(name = "patronymic", column = @Column(name = "w_patronomyc")),
            @AttributeOverride(name = "dateOfBirthday", column = @Column(name = "w_date_of_birth")),
            @AttributeOverride(name = "address.postCode", column = @Column(name = "w_post_index")),
            @AttributeOverride(name = "address.building", column = @Column(name = "w_building")),
            @AttributeOverride(name = "address.extension", column = @Column(name = "w_extension")),
            @AttributeOverride(name = "address.apartment", column = @Column(name = "w_apartment")),
            @AttributeOverride(name = "passportSerial", column = @Column(name = "w_pasport_seria")),
            @AttributeOverride(name = "passportNumber", column = @Column(name = "w_passport_number")),
            @AttributeOverride(name = "issueDate", column = @Column(name = "w_passport_date")),
            @AttributeOverride(name = "studentNumber", column = @Column(name = "w_student_number"))
    })
    @Embedded
    private Adult wife;

    @AssociationOverrides({
            @AssociationOverride(name = "address.street", joinColumns = @JoinColumn(name = "h_street_code")),
            @AssociationOverride(name = "passportOffice", joinColumns = @JoinColumn(name = "h_passport_office_id")),
            @AssociationOverride(name = "university", joinColumns = @JoinColumn(name = "h_university_id"))
    })
    @AttributeOverrides({
            @AttributeOverride(name = "surName", column = @Column(name = "h_surname")),
            @AttributeOverride(name = "givenName", column = @Column(name = "h_given_name")),
            @AttributeOverride(name = "patronymic", column = @Column(name = "h_patronomyc")),
            @AttributeOverride(name = "dateOfBirthday", column = @Column(name = "h_date_of_birth")),
            @AttributeOverride(name = "address.postCode", column = @Column(name = "h_post_index")),
            @AttributeOverride(name = "address.building", column = @Column(name = "h_building")),
            @AttributeOverride(name = "address.extension", column = @Column(name = "h_extension")),
            @AttributeOverride(name = "address.apartment", column = @Column(name = "h_apartment")),
            @AttributeOverride(name = "passportSerial", column = @Column(name = "h_pasport_seria")),
            @AttributeOverride(name = "passportNumber", column = @Column(name = "h_passport_number")),
            @AttributeOverride(name = "issueDate", column = @Column(name = "h_passport_date")),
            @AttributeOverride(name = "studentNumber", column = @Column(name = "h_student_number"))

    })
    @Embedded
    private Adult husband;

    @Column(name = "certificate_number")
    private String certificateNumber;

    @Column(name = "marriage_date")
    private LocalDate marriageDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "register_office_id")
    private RegisterOffice registerOffice;
}
