package edu.javacourse.student.domain;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "jc_student_child")
public class StudentOrderChild {
    @Id
    @Column(name = "student_child_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentOrderChildId;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_order_id")
    private StudentOrder studentOrder;


}
