package com.example.api.service;


import com.example.api.model.Classroom;
import com.example.api.model.Classroom;
import com.example.api.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public Classroom createClassroom (Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public List<Classroom> getAllClassrooms(){
        return classroomRepository.findAll();
    }
    public Classroom getClassroomById(int id){
        return classroomRepository.findById(id).orElse(null);
    }

    public Classroom updateClassroom(int id, Classroom classroom) {
        classroom.setId(id);
        return classroomRepository.save(classroom);
    }

    public void deleteClassroom(int id){
        classroomRepository.deleteById(id);
    }
}
