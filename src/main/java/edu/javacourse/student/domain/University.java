package edu.javacourse.student.domain;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "jc_university")
public class University {
    @Id
    @Column(name = "university_id")
    private Long universityId;
    @Column(name = "university_name")
    private String universityName;
}
