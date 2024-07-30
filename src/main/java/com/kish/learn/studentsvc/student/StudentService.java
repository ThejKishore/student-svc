package com.kish.learn.studentsvc.student;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;


    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream().map(Student::new).toList();
    }

    @Transactional(readOnly = true)
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .map(Student::new)
                .orElse(null);
    }

    @Transactional
    public Student createStudent(Student student) {
        try{
            StudentDao studentDao = new StudentDao(student);
            StudentDao studentDao1 = studentRepository.save(studentDao);
            return new Student(studentDao1);
        }catch (Exception e){
            log.error("createStudent error", e);
            return null;
        }
    }

    @Transactional
    public Student updateStudent(Long studentId, Student student)  {
        try {
            StudentDao studentDao = fetchStudent(studentId, student);
            Student student1 = new Student(studentRepository.save(studentDao));
            return new Student(student1.id(), student1.firstName(), student1.lastName(), student1.gender(), student1.age());
        }catch (Exception e){
            log.error("update student failed", e);
            return null;
        }
    }

    @Transactional
    public Student removeStudent(Long studentId)  {
        try {
            Student student = new Student(studentRepository.findById(studentId).get());
            studentRepository.deleteById(studentId);
            return student;
        }catch (Exception e){
            log.error("remove student failed", e);
            return null;
        }
    }

    private StudentDao fetchStudent(Long studentId, Student student) {
        StudentDao studentDao = studentRepository.findById(studentId)
                .orElse(new StudentDao(student));
        studentDao.setGender(student.gender());
        studentDao.setAge(student.age());
        studentDao.setFirstName(student.firstName());
        studentDao.setLastName(student.lastName());
        return studentDao;
    }

}
