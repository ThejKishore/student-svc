package com.kish.learn.studentsvc.student;

import com.kish.learn.studentsvc.marks.Marks;
import com.kish.learn.studentsvc.marks.StudentMark;
import com.kish.learn.studentsvc.marks.StudentMarkRepository;
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

    private final StudentMarkRepository studentMarkRepository;

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream().map(Student::new).toList();
    }

    @Transactional(readOnly = true)
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .map(Student::new)
                .map(this::fetchStudentMarks)
                .orElse(null);
    }

    @Transactional(readOnly = true)
    public Student fetchStudentMarks(Student student){
        List<Marks> marks = studentMarkRepository.findStudentMarkByStudentId(student.id())
                .stream()
                .map(Marks::new)
                .toList();
        return new Student(student.id(), student.firstName(), student.lastName(), student.sex(), student.age(), student.sectionId(),marks);
    }



    @Transactional
    public Student createStudent(Student student) {
        try{
            StudentDao studentDao = new StudentDao(student);
            Student student1 = new Student(studentRepository.save(studentDao));
            if(!student.marks().isEmpty()){
                List<Marks> marks = student.marks().stream()
                        .map(StudentMark::new)
                        .map(studentMarkRepository::save)
                        .map(Marks::new)
                        .toList();
                log.debug("marks : {} ",marks);
                return new Student(student1.id(), student1.firstName(), student1.lastName(), student1.sex(), student1.age(), student1.sectionId(),marks);
            }
            return student1;
        }catch (Exception e){
            return null;
        }
    }

    @Transactional
    public Student updateStudent(Long studentId, Student student)  {
        try {
            StudentDao studentDao = fetchStudent(studentId, student);
            Student student1 = new Student(studentRepository.save(studentDao));
            List<Marks> marks = student.marks().stream()
                    .map(StudentMark::new)
                    .map(studentMarkRepository::save)
                     .map(Marks::new)
                    .toList();
            log.debug("marks : {} ",marks);
            return new Student(student1.id(), student1.firstName(), student1.lastName(), student1.sex(), student1.age(), student1.sectionId(),marks);
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
            studentMarkRepository.deleteAllByStudentId(studentId);
            return student;
        }catch (Exception e){
            log.error("remove student failed", e);
            return null;
        }
    }

    private StudentDao fetchStudent(Long studentId, Student student) {
        StudentDao studentDao = studentRepository.findById(studentId)
                .orElse(new StudentDao(student));
        studentDao.setSectionId(student.sectionId());
        studentDao.setSex(student.sex());
        studentDao.setAge(student.age());
        studentDao.setFirstName(student.firstName());
        studentDao.setLastName(student.lastName());
        return studentDao;
    }

}
