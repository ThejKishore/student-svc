package com.kish.learn.studentsvc.marks;

import java.io.Serializable;

public record Marks(Long studentId, Long subjectId, Integer marks) implements Serializable {
    public Marks(StudentMark studentMark) {
        this(studentMark.getStudentMarkId().getStudentId(), studentMark.getStudentMarkId().getSubjectId(), studentMark.getSubjectMark());
    }
}
