package com.example.api.service;

import com.example.api.model.Student;
import com.example.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent (Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(int id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(int id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }
}
