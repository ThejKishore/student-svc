package com.kish.learn.studentsvc.subject;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record Subject(Long id, String subjectName) implements Serializable {
    public Subject(SubjectDao subjectDao){
        this(subjectDao.getId(), subjectDao.getSubjectName());
    }
}
