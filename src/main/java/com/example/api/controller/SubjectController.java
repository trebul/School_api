package com.example.api.controller;

import com.example.api.model.Subject;
import com.example.api.service.SubjectServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subject")
public class SubjectController {

    @Autowired
    private SubjectServiceImpl subjectServiceImpl;

    private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);
    @GetMapping("")
    public List<Subject> getAllSubjects(){
        return subjectServiceImpl.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable int id) {
        logger.info("GET request Subject id in response " + id);
        return subjectServiceImpl.getSubjectById(id);
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject){
        logger.info("POST request Subject in response {} ", subject);
        return subjectServiceImpl.createSubject(subject);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable int id, @RequestBody Subject subject) {
        logger.info("PUT request Subject id in response " + id);
        return subjectServiceImpl.updateSubject(id, subject);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable int id){
        logger.info("DELETE request Subject id in response " + id);
        subjectServiceImpl.deleteSubject(id);
    }
}
