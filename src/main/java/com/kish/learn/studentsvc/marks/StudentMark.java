package com.kish.learn.studentsvc.marks;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "student_marks")
public class StudentMark {

    @EmbeddedId
    private StudentMarkId studentMarkId;

    @Column(name = "subject_mark")
    private Integer subjectMark;

    public StudentMark(){}

    public StudentMark(Marks marks){
        this.studentMarkId = new StudentMarkId(marks.studentId(), marks.subjectId());
        this.subjectMark = marks.marks();
    }
}