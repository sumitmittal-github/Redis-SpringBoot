package com.sumit.controller;

import com.sumit.entity.Student;
import com.sumit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> listStudents(){
        List<Student> list = studentService.listAllStudents();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return new ResponseEntity<>("Deleted Student !!", HttpStatus.OK);
    }


}
