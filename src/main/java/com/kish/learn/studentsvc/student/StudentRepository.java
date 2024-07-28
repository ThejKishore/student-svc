package com.kish.learn.studentsvc.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentDao, Long> {
}