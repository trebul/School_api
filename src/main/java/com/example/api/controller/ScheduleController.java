package com.example.api.controller;

import com.example.api.model.Schedule;
import com.example.api.service.ScheduleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleServiceImpl scheduleservice;

    private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);

    @GetMapping("")
    public List<Schedule> getAllSchedules(){
        return scheduleservice.getAllSchedules();
    }

    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable int id) {
        logger.info("GET request Schedule id in response " + id);
        return scheduleservice.getScheduleById(id);
    }

    @PostMapping
    public ResponseEntity<String> createSchedule(@RequestBody Schedule schedule){
        logger.info("POST request Schedule in response {}", schedule);
        //přidat checky
        if(schedule.getClassroom() == null){
            return ResponseEntity.badRequest().body("Classroom is required");
        }
        if(schedule.getSubject() == null || schedule.getSubject().isEmpty()){
            return ResponseEntity.badRequest().body("At least One Subject is expected");
        }
        if(schedule.getSchoolYear() == null || schedule.getSchoolYear().isEmpty()){
            return ResponseEntity.badRequest().body("School year is expected");
        }
        Schedule savedSchedule = scheduleservice.createSchedule(schedule);
        return ResponseEntity.ok("Schedule added: " + savedSchedule);
    }

    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable int id, @RequestBody Schedule schedule) {
        logger.info("PUT request Schedule id in response " + id);
        logger.info("PUT request Schedule in response {}", schedule);
        return scheduleservice.updateSchedule(id, schedule);
    }
    @GetMapping("/year/{schoolYear}")
    public List<Schedule> getSchoolYear(@RequestBody String schoolYear) {
        return scheduleservice.findBySchoolYear(schoolYear);
    }
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable int id){
        logger.info("DELETE request Schedule id in response " + id);
        scheduleservice.deleteSchedule(id);
    }
}
