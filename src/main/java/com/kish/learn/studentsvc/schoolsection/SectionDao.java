package com.kish.learn.studentsvc.schoolsection;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "section")
public class SectionDao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "section_id_gen")
    @SequenceGenerator(name = "section_id_gen", sequenceName = "section_section_id_seq", allocationSize = 1)
    @Column(name = "section_id", nullable = false)
    private Long id;

    @Column(name = "section_name", length = Integer.MAX_VALUE)
    private String sectionName;

    @Column(name = "section_teacher_name", length = Integer.MAX_VALUE)
    private String sectionTeacherName;

}