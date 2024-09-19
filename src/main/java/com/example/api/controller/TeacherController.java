package com.example.api.controller;

import com.example.api.model.Teacher;
import com.example.api.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllteachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherService.CreateTeacher(teacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(id, teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable int id){
        teacherService.deleeteTeacher(id);
    }
}
