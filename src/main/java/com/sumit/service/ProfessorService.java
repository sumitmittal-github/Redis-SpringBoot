package com.sumit.service;

import com.sumit.entity.Professor;
import com.sumit.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public void addProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    public List<Professor> listAllProfessors() {
        return professorRepository.findAll();
    }

    // Cache only Professors whose age is greater than 30.
    @Cacheable(value="professorCache", key="#id", unless = "#result.age<=30")
    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    @CachePut(value = "professorCache", key = "#professor.id")
    public void updateProfessor(Professor professor) {
        professorRepository.save(professor);
    }

    @CacheEvict(value="professorCache", key="#id")
    public void deleteProfessorById(Long id) {
        professorRepository.deleteById(id);
    }

}