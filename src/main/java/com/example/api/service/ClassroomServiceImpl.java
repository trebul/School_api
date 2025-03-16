package com.example.api.service;


import com.example.api.model.Classroom;
import com.example.api.model.Exam;
import com.example.api.repository.ClassroomRepository;
import com.example.api.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private ExamRepository examRepository;

    public Classroom createClassroom (Classroom classroom) {
        Optional<Classroom> foundID = classroomRepository.findById(classroom.getId());
        if(foundID.isEmpty()) {
            return classroomRepository.save(classroom);
        }
        else {
            throw new IllegalStateException("Classroom already exists");
        }
    }

    public List<Classroom> getAllClassrooms(){
        return classroomRepository.findAll();
    }
    public Classroom getClassroomById(int id){
        return classroomRepository.findById(id).orElse(null);
    }

    public Classroom updateClassroom(int id, Classroom classroom) {
        Optional<Classroom> foundID = classroomRepository.findById(id);
        if(foundID.isPresent()) {
            classroom.setId(id);
            return classroomRepository.save(classroom);
        }
        else {
            throw new IllegalStateException("Classroom doesnt exist");
        }
    }

    public void deleteClassroom(int id){
        classroomRepository.deleteById(id);
    }

    @Override
    public List<Exam> getExamByClassroomId(int id) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Exam not found"));
        return classroom.getExams();
    }

}
