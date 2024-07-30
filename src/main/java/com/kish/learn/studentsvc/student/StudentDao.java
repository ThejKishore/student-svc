package com.kish.learn.studentsvc.student;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "student")
public class StudentDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid", nullable = false)
    private Long id;

    @Column(name = "firstname", length = Integer.MAX_VALUE)
    private String firstName;

    @Column(name = "lastname", length = Integer.MAX_VALUE)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = Integer.MAX_VALUE)
    private Gender gender;

    @Column(name = "age")
    private Integer age;


    public StudentDao() {}

    public StudentDao(Student student){
        super();
        this.setAge(student.age());
        this.setGender(student.gender());
        this.setFirstName(student.firstName());
        this.setLastName(student.lastName());
    }

}