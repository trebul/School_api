package com.example.api.service;

import com.example.api.model.Teacher;
import com.example.api.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher CreateTeacher(Teacher teacher)  {
        Optional<Teacher> foundId = teacherRepository.findById(teacher.getTeacherid());
        if(foundId.isEmpty()) {
            return teacherRepository.save(teacher);
        }
        else {
            throw new IllegalStateException("Teacher already exists");
        }
    }

    public List<Teacher> getAllTeachers()  {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById (int id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher updateTeacher(int id, Teacher teacher) {
        Optional<Teacher> foundId = teacherRepository.findById(teacher.getTeacherid());
        if(foundId.isPresent()) {
            teacher.setTeacherid(id);
            return teacherRepository.save(teacher);
        }
        else {
            throw new IllegalStateException("Teacher not found");
        }
    }

    public void deleteTeacher(int id) {
        teacherRepository.deleteById(id);
    }
}
