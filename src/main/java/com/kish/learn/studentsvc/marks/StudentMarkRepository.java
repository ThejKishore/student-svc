package com.kish.learn.studentsvc.marks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentMarkRepository extends JpaRepository<StudentMark, StudentMarkId> {

    @Query(nativeQuery = true , value = " select * from student_marks where student_id = ?1")
    List<StudentMark> findStudentMarkByStudentId(Long studentId);

    @Modifying
    @Query(nativeQuery = true , value = " delete from student_marks where student_id = ?1")
    void deleteAllByStudentId(Long studentId);
}