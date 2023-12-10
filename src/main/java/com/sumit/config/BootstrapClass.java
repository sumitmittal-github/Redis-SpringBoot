package com.sumit.config;

import com.sumit.entity.Professor;
import com.sumit.entity.Student;
import com.sumit.service.ProfessorService;
import com.sumit.service.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootstrapClass {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ProfessorService professorService;

    // Temporary method added here so that when we will start the application then 4 dummy objects will be added in the DB

    @PostConstruct
    public void addTestDataInDB(){
        Student studentOne = new Student("Sumit", "Mittal", 25, "sumit@gmail.com");
        studentService.addStudent(studentOne);
        Student studentTwo = new Student("Lokesh", "Mittal", 26, "lokesh@gmail.com");
        studentService.addStudent(studentTwo);

        Professor professorOne = new Professor("Prof1", "LN1", 45, "prof1@gmail.com");
        professorService.addProfessor(professorOne);
        Professor professorTwo = new Professor("Prof2", "LN2", 22, "prof2@gmail.com");
        professorService.addProfessor(professorTwo);
    }

}