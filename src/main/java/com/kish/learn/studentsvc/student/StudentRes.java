package com.kish.learn.studentsvc.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping(value = {"/v1/students"})
@RestController
public class StudentRes {

    private final StudentService studentService;

    @CrossOrigin(originPatterns = {"*","localhost:5173"})
    @GetMapping( produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @CrossOrigin(originPatterns = {"*","localhost:5173"})
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE} ,produces = {MediaType.APPLICATION_JSON_VALUE})
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @CrossOrigin(originPatterns = {"*","localhost:5173"})
    @PutMapping(value = "/{studentid}", consumes = {MediaType.APPLICATION_JSON_VALUE} ,produces = {MediaType.APPLICATION_JSON_VALUE})
    public Student createStudent(@PathVariable(value = "studentid")Long studentid, @RequestBody Student student) {
        return studentService.updateStudent(studentid, student);
    }

    @CrossOrigin(originPatterns = {"*","localhost:5173"})
    @DeleteMapping(value = "/{studentid}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Student deleteStudent(@PathVariable(value = "studentid")Long studentid) {
        return studentService.removeStudent(studentid);
    }

}
