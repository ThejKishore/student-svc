package com.kish.learn.studentsvc;

import com.kish.learn.studentsvc.schoolsection.SectionRepository;
import com.kish.learn.studentsvc.student.StudentRepository;
import com.kish.learn.studentsvc.subject.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSvcApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(SectionRepository sectionRepository,
                                    SubjectRepository subjectRepository,
                                    StudentRepository studentRepository) {
        return args -> {
            sectionRepository.findAll().stream().forEach(System.out::println);
            subjectRepository.findAll().stream().forEach(System.out::println);
            studentRepository.findAll().stream().forEach(System.out::println);
        };
    }
}
