package com.example.api.controller;

import com.example.api.mapper.Mapper;
import com.example.api.model.Student;
import com.example.api.model.StudentDTO;
import com.example.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private Mapper mapper;

    @PostMapping
    public Student createUser(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable int id){
        return mapper.getStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

}
