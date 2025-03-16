package com.example.api.controller;

import com.example.api.model.Homework;
import com.example.api.service.HomeworkServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/homework")
public class HomeworkController {

    @Autowired
    private HomeworkServiceImpl homeworkService;

    private static final Logger logger = LoggerFactory.getLogger(GradesController.class);

    @GetMapping("")
    public List<Homework> getAllHomeworks(){
        return homeworkService.getAllHomeworks();
    }
    @GetMapping("/{id}")
    public Homework getHomeworkById(@PathVariable int id) {
        logger.info("GET request Homework id in response " + id);
        return homeworkService.getHomeworkById(id);
    }

    @PutMapping("/{id}")
    public Homework updateHomework(@PathVariable int id, @RequestBody Homework homework) {
        logger.info("PUT request Homework id in response " + id);
        logger.info("PUT request Homework in response {}", homework);
        return homeworkService.updateHomework(id, homework);
    }

    @PostMapping("")
    public Homework createHomework(@RequestBody Homework homework) {
        logger.info("POST request Homework in response {}", homework);
        return homeworkService.createHomework(homework);
    }

    @DeleteMapping("/{id}")
    public void deleteHomework(@PathVariable int id) {
        logger.info("DELETE request Homework id in response " + id);
        homeworkService.deleteHomework(id);
    }
}
