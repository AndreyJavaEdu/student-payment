package edu.javacourse.student.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jc_order_status")
public class StudentOrderStatus {
    @Id
    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "status_name")
    private String statusName;
}
