package com.example.api.controller;

import com.example.api.model.Classroom;
import com.example.api.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/classroom")
@RestController
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping("")
    public List<Classroom> getAllClassrooms(){
        return classroomService.getAllClassrooms();
    }

    @GetMapping("/{id}")
    public Classroom getClassroomById(@PathVariable int id) {
        return classroomService.getClassroomById(id);
    }

    @PostMapping
    public Classroom createClassroom(@RequestBody Classroom classroom){
        return classroomService.createClassroom(classroom);
    }

    @PutMapping("/{id}")
    public Classroom updateClassroom(@PathVariable int id, @RequestBody Classroom classroom) {
        return classroomService.updateClassroom(id, classroom);
    }

    @DeleteMapping("/{id}")
    public void deleteClassroom(@PathVariable int id){
        classroomService.deleteClassroom(id);
    }

}
