package edu.javacourse.student.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "jc_student_order_tmp")
public class StudentOrder {
    @Id
    @Column(name = "student_order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentOrderId;
    @AssociationOverrides({
            @AssociationOverride(name = "address.street", joinColumns = @JoinColumn(name = "w_street_code"))
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
            @AttributeOverride(name = "issueDate", column = @Column(name = "w_passport_date"))
    })
    @Embedded
    private Adult wife;

    @AssociationOverrides({
            @AssociationOverride(name = "address.street", joinColumns = @JoinColumn(name = "h_street_code"))
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
            @AttributeOverride(name = "issueDate", column = @Column(name = "h_passport_date"))
    })
    @Embedded
    private Adult husband;


}
