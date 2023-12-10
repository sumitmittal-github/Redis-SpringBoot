package com.sumit.controller;

import com.sumit.entity.Professor;
import com.sumit.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> listProfessors(){
        List<Professor> list = professorService.listAllProfessors();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Professor> addProfessor(@RequestBody Professor professor){
        professorService.addProfessor(professor);
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Professor> updateProfessor(@RequestBody Professor professor){
        professorService.updateProfessor(professor);
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id){
        Professor professor = professorService.getProfessorById(id);
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfessorById(@PathVariable Long id){
        professorService.deleteProfessorById(id);
        return new ResponseEntity<>("Deleted Professor !!", HttpStatus.OK);
    }


}
