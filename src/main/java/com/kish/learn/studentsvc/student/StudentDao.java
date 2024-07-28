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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_gen")
    @SequenceGenerator(name = "student_id_gen", sequenceName = "student_student_id_seq", allocationSize = 1)
    @Column(name = "student_id", nullable = false)
    private Long id;

    @Column(name = "first_name", length = Integer.MAX_VALUE)
    private String firstName;

    @Column(name = "last_name", length = Integer.MAX_VALUE)
    private String lastName;

    @Column(name = "sex", length = Integer.MAX_VALUE)
    private String sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "section_id")
    private Long sectionId;

    public StudentDao() {}

    public StudentDao(Student student){
        super();
        this.setAge(student.age());
        this.setSex(student.sex());
        this.setFirstName(student.firstName());
        this.setLastName(student.lastName());
        this.setSectionId(student.sectionId());
    }

}