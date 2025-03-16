package com.example.api.service;

import com.example.api.model.*;
import com.example.api.repository.GradeRepository;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GradesServiceTest {
    @Mock
    private GradeRepository gradeRepository;

    @InjectMocks
    private GradesServiceImpl gradesServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void createGrades() {
        Grades grades = new Grades();
        grades.setId(1);
        grades.setGrade(2);
        grades.setDateOfGrade(LocalDate.parse("12.10.2023"));
        Address address = new Address();
        address.setId(1);
        address.setCity("Plzeň");
        address.setStreet("Moravská");
        address.setStreetNumber(154);
        Teacher teacher = new Teacher();
        teacher.setTeacherid(1);
        teacher.setAge(38);
        teacher.setFirstname("Karel");
        teacher.setSalary(45000);
        teacher.setLastname("Vomáčka");
        Student student = new Student();
        student.setId(1);
        student.setAge(16);
        student.setFirstname("Michal");
        student.setLastname("Malý");
        student.setAddress(address);
        grades.setStudent(student);
        grades.setTeacher(teacher);

        when(gradeRepository.save(grades)).thenReturn(grades);

        Grades result = gradesServiceImpl.createGrades(grades);

        assertNotNull(result);
        assertEquals(grades, result);
        verify(gradeRepository, times(1)).save(grades);
    }

    @Test
    void getAllGrades() {
        Grades grades = new Grades();
        grades.setId(1);
        grades.setGrade(2);
        grades.setDateOfGrade(LocalDate.parse("12.10.2023"));
        Address address = new Address();
        address.setId(1);
        address.setCity("Plzeň");
        address.setStreet("Moravská");
        address.setStreetNumber(154);
        Teacher teacher = new Teacher();
        teacher.setTeacherid(1);
        teacher.setAge(38);
        teacher.setFirstname("Karel");
        teacher.setSalary(45000);
        teacher.setLastname("Vomáčka");
        Student student = new Student();
        student.setId(1);
        student.setAge(16);
        student.setFirstname("Michal");
        student.setLastname("Malý");
        student.setAddress(address);
        grades.setStudent(student);
        grades.setTeacher(teacher);

        when(gradeRepository.findAll()).thenReturn(Collections.singletonList(grades));

        List<Grades> gradesList = gradesServiceImpl.getAllGrades();
        assertNotNull(grades);
        assertEquals(1, gradesList.size());
        assertEquals(grades, gradesList.get(0));

        verify(gradeRepository, times(1)).findAll();
    }

    @Test
    void getGradesById() {
        Grades grades = new Grades();
        grades.setId(1);
        grades.setGrade(2);
        grades.setDateOfGrade(LocalDate.parse("12.10.2023"));
        Address address = new Address();
        address.setId(1);
        address.setCity("Plzeň");
        address.setStreet("Moravská");
        address.setStreetNumber(154);
        Teacher teacher = new Teacher();
        teacher.setTeacherid(1);
        teacher.setAge(38);
        teacher.setFirstname("Karel");
        teacher.setSalary(45000);
        teacher.setLastname("Vomáčka");
        Student student = new Student();
        student.setId(1);
        student.setAge(16);
        student.setFirstname("Michal");
        student.setLastname("Malý");
        student.setAddress(address);
        grades.setStudent(student);
        grades.setTeacher(teacher);

        when(gradeRepository.findById(1)).thenReturn(Optional.of(grades));

        Grades result = gradesServiceImpl.getGradesById(1);
        assertNotNull(result);
        assertEquals(grades, result);
        verify(gradeRepository, times(1)).findById(1);
    }

    @Test
    void updateGrades() {
        Grades existingGrades = getGrades();

        Grades updatedGrades = getUpdatedGrades();

        when(gradeRepository.findById(1)).thenReturn(Optional.of(existingGrades));

        when(gradeRepository.save(updatedGrades)).thenReturn(updatedGrades);

        Grades result = gradesServiceImpl.updateGrades(1, updatedGrades);

        assertNotNull(result);
        assertEquals(updatedGrades.getDateOfGrade(), result.getDateOfGrade());
        assertEquals(updatedGrades.getStudent(), result.getStudent());
        assertEquals(updatedGrades.getTeacher(), result.getTeacher());
        verify(gradeRepository, times(1)).save(updatedGrades);
    }

    @NotNull
    private static Grades getUpdatedGrades() {
        Grades updatedGrades = new Grades();
        updatedGrades.setId(1);
        updatedGrades.setGrade(2);
        updatedGrades.setDateOfGrade(LocalDate.parse("15.10.2023"));
        Address updatedAddress = new Address();
        updatedAddress.setId(1);
        updatedAddress.setCity("Praha");
        updatedAddress.setStreet("Rybalkova");
        updatedAddress.setStreetNumber(14);
        Teacher updatedTeacher = new Teacher();
        updatedTeacher.setTeacherid(1);
        updatedTeacher.setAge(48);
        updatedTeacher.setFirstname("Tomáš");
        updatedTeacher.setSalary(40000);
        updatedTeacher.setLastname("Jedno");
        Student updatedStudent = new Student();
        updatedStudent.setId(1);
        updatedStudent.setAge(17);
        updatedStudent.setFirstname("Martin");
        updatedStudent.setLastname("Zelený");
        updatedStudent.setAddress(updatedAddress);
        updatedGrades.setStudent(updatedStudent);
        updatedGrades.setTeacher(updatedTeacher);
        return updatedGrades;
    }

    @NotNull
    private static Grades getGrades() {
        Grades existingGrades = new Grades();
        existingGrades.setId(1);
        existingGrades.setGrade(3);
        existingGrades.setDateOfGrade(LocalDate.parse("12.10.2023"));
        Address existingAddress = new Address();
        existingAddress.setId(1);
        existingAddress.setCity("Plzeň");
        existingAddress.setStreet("Moravská");
        existingAddress.setStreetNumber(154);
        Teacher existingTeacher = new Teacher();
        existingTeacher.setTeacherid(1);
        existingTeacher.setAge(38);
        existingTeacher.setFirstname("Karel");
        existingTeacher.setSalary(45000);
        existingTeacher.setLastname("Vomáčka");
        Student existingStudent = new Student();
        existingStudent.setId(1);
        existingStudent.setAge(16);
        existingStudent.setFirstname("Michal");
        existingStudent.setLastname("Malý");
        existingStudent.setAddress(existingAddress);
        existingGrades.setStudent(existingStudent);
        existingGrades.setTeacher(existingTeacher);
        return existingGrades;
    }

    @Test
    void deleteGrades() {
        int gradeId = 1;

        gradesServiceImpl.deleteGrades(gradeId);

        verify(gradeRepository, times(1)).deleteById(gradeId);
    }
}