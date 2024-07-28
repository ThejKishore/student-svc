package com.kish.learn.studentsvc.student;

import com.kish.learn.studentsvc.marks.Marks;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * DTO for {@link StudentDao}
 */
public record Student(Long id,
                      String firstName,
                      String lastName,
                      String sex,
                      Integer age,
                      Long sectionId,
                      List<Marks> marks) implements Serializable {

    public Student(StudentDao studentDao){
        this(studentDao.getId(), studentDao.getFirstName(), studentDao.getLastName(), studentDao.getSex(), studentDao.getAge(), studentDao.getSectionId(), Collections.emptyList());
    }
}