package com.example.api.controller;

import com.example.api.model.Grades;
import com.example.api.service.GradesServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradesController {

    @Autowired
    private GradesServiceImpl gradesServiceImpl;


    private static final Logger logger = LoggerFactory.getLogger(GradesController.class);
    @GetMapping("")
    public List<Grades> getAllGrades(){
        return gradesServiceImpl.getAllGrades();
    }

    @GetMapping("/{id}")
    public Grades getGradesById(@PathVariable int id) {
        logger.info("GET request Grade id in response " + id);
        return gradesServiceImpl.getGradesById(id);
    }
    @GetMapping("/{id}/student")
    public List<Grades> getGradesByStudentId(@PathVariable int id) {
        logger.info("GET request Grade id in response " + id);
        return gradesServiceImpl.getStudentGrades(id);
    }
    @PostMapping("")
    public Grades createGrades(@RequestBody Grades grades){
        logger.info("POST request Grade in response {}", grades);
        return gradesServiceImpl.createGrades(grades);
    }

    @PutMapping("/{id}")
    public Grades updateGrades(@PathVariable int id, @RequestBody Grades grades) {
        logger.info("PUT request Grade id in response " + id);
        logger.info("PUT request Grade in response {}", grades);
        return gradesServiceImpl.updateGrades(id, grades);
    }

    @DeleteMapping("/{id}")
    public void deleteGrades(@PathVariable int id){
        logger.info("DELETE request Grade id in response " + id);
        gradesServiceImpl.deleteGrades(id);
    }
}
