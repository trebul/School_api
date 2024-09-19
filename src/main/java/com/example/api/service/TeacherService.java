package com.example.api.service;

import com.example.api.model.Teacher;
import com.example.api.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher CreateTeacher(Teacher teacher)  {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllteachers()  {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById (int id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher updateTeacher(int id, Teacher teacher) {
        teacher.setTeacherid(id);
        return teacherRepository.save(teacher);
    }

    public void deleeteTeacher(int id) {
        teacherRepository.deleteById(id);
    }
}
