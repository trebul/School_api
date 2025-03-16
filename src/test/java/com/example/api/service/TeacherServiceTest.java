package com.example.api.service;

import com.example.api.model.Teacher;
import com.example.api.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeacherServiceTest {
    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private TeacherServiceImpl teacherServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void createTeacher() {
        Teacher teacher = new Teacher();
        teacher.setLastname("Venclík");
        teacher.setFirstname("Karel");
        teacher.setSalary(50000);
        teacher.setAge(45);
        teacher.setTeacherid(1);

        when(teacherRepository.save(teacher)).thenReturn(teacher);

        Teacher result = teacherServiceImpl.CreateTeacher(teacher);

        assertNotNull(result);
        assertEquals(teacher, result);
        verify(teacherRepository, times(1)).save(teacher);
    }

    @Test
    void getAllTeachers() {
        Teacher teacher = new Teacher();
        teacher.setLastname("Venclík");
        teacher.setFirstname("Karel");
        teacher.setSalary(50000);
        teacher.setAge(45);
        teacher.setTeacherid(1);

        when(teacherRepository.findAll()).thenReturn(Collections.singletonList(teacher));

        List<Teacher> teacherList = teacherServiceImpl.getAllTeachers();
        assertNotNull(teacherList);
        assertEquals(1, teacherList.size());
        assertEquals(teacher, teacherList.get(0));

        verify(teacherRepository, times(1)).findAll();
    }

    @Test
    void getTeacherById() {
        Teacher teacher = new Teacher();
        teacher.setLastname("Venclík");
        teacher.setFirstname("Karel");
        teacher.setSalary(50000);
        teacher.setAge(45);
        teacher.setTeacherid(1);

        when(teacherRepository.findById(1)).thenReturn(Optional.of(teacher));

        Teacher result = teacherServiceImpl.getTeacherById(1);
        assertNotNull(result);
        assertEquals(teacher, result);
        verify(teacherRepository, times(1)).findById(1);
    }

    @Test
    void updateTeacher() {
        Teacher existingTeacher = new Teacher();
        existingTeacher.setLastname("Venclík");
        existingTeacher.setFirstname("Karel");
        existingTeacher.setSalary(50000);
        existingTeacher.setAge(45);
        existingTeacher.setTeacherid(1);

        Teacher updatedTeacher = new Teacher();
        updatedTeacher.setLastname("Vašek");
        updatedTeacher.setFirstname("Tomáš");
        updatedTeacher.setSalary(40000);
        updatedTeacher.setAge(25);
        updatedTeacher.setTeacherid(1);

        when(teacherRepository.findById(1)).thenReturn(Optional.of(existingTeacher));

        when(teacherRepository.save(updatedTeacher)).thenReturn(updatedTeacher);

        Teacher result = teacherServiceImpl.updateTeacher(1, updatedTeacher);

        assertNotNull(result);
        assertEquals(updatedTeacher.getFirstname(), result.getFirstname());
        assertEquals(updatedTeacher.getLastname(), result.getLastname());
        assertEquals(updatedTeacher.getAge(), result.getAge());
        assertEquals(updatedTeacher.getSalary(), result.getSalary());
        verify(teacherRepository, times(1)).save(updatedTeacher);
    }

    @Test
    void deleteTeacher() {
        int teacherId = 1;

        teacherServiceImpl.deleteTeacher(teacherId);

        verify(teacherRepository, times(1)).deleteById(teacherId);
    }
}