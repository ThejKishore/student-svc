package com.kish.learn.studentsvc.student;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import java.io.Serializable;

/**
 * DTO for {@link StudentDao}
 */
public record Student(Long id,
                      String firstName,
                      String lastName,
                      @JsonEnumDefaultValue  Gender gender,
                      Integer age) implements Serializable {

    public Student(StudentDao studentDao){
        this(studentDao.getId(),
                studentDao.getFirstName(),
                studentDao.getLastName(),
                studentDao.getGender(),
                studentDao.getAge());
    }

}