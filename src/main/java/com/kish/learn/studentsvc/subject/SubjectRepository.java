package com.kish.learn.studentsvc.subject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectDao, Long> {
}