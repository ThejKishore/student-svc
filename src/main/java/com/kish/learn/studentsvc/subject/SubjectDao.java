package com.kish.learn.studentsvc.subject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "subject")
public class SubjectDao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_id_gen")
    @SequenceGenerator(name = "subject_id_gen", sequenceName = "subject_subject_id_seq", allocationSize = 1)
    @Column(name = "subject_id", nullable = false)
    private Long id;

    @Column(name = "subject_name", length = Integer.MAX_VALUE)
    private String subjectName;

    public SubjectDao(){}

    public SubjectDao(Long id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
    }

    public SubjectDao(Subject subject) {
        if(subject != null) {
            if(subject.id() != null) {
                this.id = subject.id().longValue();
            }
            this.subjectName = subject.subjectName();
        }
    }

}