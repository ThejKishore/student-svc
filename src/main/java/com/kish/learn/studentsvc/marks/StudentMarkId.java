package com.kish.learn.studentsvc.marks;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Embeddable
public class StudentMarkId {
    @Column(name = "student_id")
    private Long studentId;


    @Column(name = "subject_id")
    private Long subjectId;

    public StudentMarkId(){

    }

    public StudentMarkId(Long studentId, Long subjectId) {
        this.studentId = studentId;
        this.subjectId = subjectId;
    }
}
