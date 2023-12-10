package com.sumit.service;

import com.sumit.entity.Student;
import com.sumit.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> listAllStudents() {
        return studentRepository.findAll();
    }

    // Cache only students whose age is less than 40.
    @Cacheable(value="studentCache", key="#id", unless = "#result.age>40")
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @CachePut(value = "studentCache", key = "#student.id")
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @CacheEvict(value="studentCache", key="#id")
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}