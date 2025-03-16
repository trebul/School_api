package com.example.api.controller;

import com.example.api.model.Exam;
import com.example.api.service.ExamServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/exam")
public class ExamController {

    @Autowired
    private ExamServiceImpl examService;
    private static final Logger logger = LoggerFactory.getLogger(GradesController.class);

    @GetMapping()
    public List<Exam> getAllExams(){
        return examService.getAllExams();
    }

    @GetMapping("{id}")
    public Exam getExamById(@PathVariable int id) {
        logger.info("GET request Exam id in response " + id);
        return examService.getExamById(id);
    }

    @GetMapping("{date}/upcoming")
    public List<Exam> upcomingExams(@PathVariable LocalDate date) {
        return examService.upcomingExams(date);
    }

    @PostMapping()
    public Exam createExam(@RequestBody Exam exam){
        logger.info("POST request Exam in response {}", exam);
        return examService.createExam(exam);
    }
    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable int id, @RequestBody Exam exam) {
        logger.info("PUT request Exam id in response " + id);
        logger.info("PUT request Exam in response {}", exam);
        return examService.updateExam(id, exam);
    }

    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable int id) {
        examService.deleteExam(id);
    }
}
