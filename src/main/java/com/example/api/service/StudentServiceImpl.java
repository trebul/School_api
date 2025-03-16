package com.example.api.service;

import com.example.api.mapper.StudentMapper;
import com.example.api.model.Student;
import com.example.api.model.StudentDTO;
import com.example.api.repository.ClassroomRepository;
import com.example.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private StudentMapper studentMapper;

    public Student createStudent (Student student) {
        Optional<Student> foundId = studentRepository.findById(student.getId());
        if (foundId.isEmpty()) {
            return studentRepository.save(student);
        }
        else {
            throw new IllegalStateException("Student already exists");
        }
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public StudentDTO getStudentById(int id){
        return studentRepository.findById(id)
                .map(studentMapper::studentToStudentDTO)
                .orElse(null);
    }

    public Student updateStudent(int id, Student student) {
        Optional<Student> foundId = studentRepository.findById(student.getId());
        if (foundId.isPresent()) {
            student.setId(id);
            return studentRepository.save(student);
        }
        else {
            throw new IllegalStateException("Student not found");
        }
    }

    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }

    @Override
    public int getClassroomByStudentId(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student not found"));
        return student.getClassroom().getId();
    }


}
