package com.example.api.service;

import com.example.api.model.Grades;
import com.example.api.model.Student;
import com.example.api.repository.GradeRepository;
import com.example.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradesServiceImpl implements GradesService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;
    public Grades createGrades (Grades grades) {
        Optional<Grades> foundId = gradeRepository.findById(grades.getId());
        if(foundId.isEmpty()) {
            return gradeRepository.save(grades);
        }
        else {
            throw new IllegalStateException("Grade already exists");
        }
    }

    public List<Grades> getAllGrades(){
        return gradeRepository.findAll();
    }
    public Grades getGradesById(int id){
        return gradeRepository.findById(id).orElse(null);
    }

    public Grades updateGrades(int id, Grades grades) {
        Optional<Grades> foundId = gradeRepository.findById(grades.getId());
        if(foundId.isPresent()) {
            grades.setId(id);
            return gradeRepository.save(grades);
        }
        else {
            throw new IllegalStateException("Grade not found");
        }
    }

    public void deleteGrades(int id){
        gradeRepository.deleteById(id);
    }

    @Override
    public List<Grades> getStudentGrades(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student not found"));
            return gradeRepository.findByStudentId(student.getId());

    }
}
