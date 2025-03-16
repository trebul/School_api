package com.example.api.service;

import com.example.api.model.Address;
import com.example.api.model.Classroom;
import com.example.api.model.Student;
import com.example.api.model.Teacher;
import com.example.api.repository.ClassroomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClassroomServiceTest {

    @Mock
    private ClassroomRepository classroomRepository;

    @InjectMocks
    private ClassroomServiceImpl classroomServiceImpl;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void createClassroom() {
        Classroom classroom = new Classroom();
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
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        classroom.setId(1);
        classroom.setName("c2d");
        classroom.setFloor(2);
        classroom.setTeacher(teacher);
        classroom.setStudent(studentList);

        when(classroomRepository.save(classroom)).thenReturn(classroom);

        Classroom result = classroomServiceImpl.createClassroom(classroom);

        assertNotNull(result);
        assertEquals(classroom, result);
        verify(classroomRepository, times(1)).save(classroom);
    }

    @Test
    void getAllClassrooms() {
        Classroom classroom = new Classroom();
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
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        classroom.setId(1);
        classroom.setName("c2d");
        classroom.setFloor(2);
        classroom.setTeacher(teacher);
        classroom.setStudent(studentList);

        when(classroomRepository.findAll()).thenReturn(Collections.singletonList(classroom));

        List<Classroom> classrooms = classroomServiceImpl.getAllClassrooms();
        assertNotNull(classrooms);
        assertEquals(1, classrooms.size());
        assertEquals(classroom, classrooms.get(0));

        verify(classroomRepository, times(1)).findAll();
    }

    @Test
    void getClassroomById() {
        Classroom classroom = new Classroom();
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
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        classroom.setId(1);
        classroom.setName("c2d");
        classroom.setFloor(2);
        classroom.setTeacher(teacher);
        classroom.setStudent(studentList);

        when(classroomRepository.findById(1)).thenReturn(Optional.of(classroom));

        Classroom result = classroomServiceImpl.getClassroomById(1);
        assertNotNull(result);
        assertEquals(classroom, result);
        verify(classroomRepository, times(1)).findById(1);
    }

    @Test
    void updateClassroom() {
        Classroom existingClassroom = new Classroom();
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
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        existingClassroom.setId(1);
        existingClassroom.setName("c2d");
        existingClassroom.setFloor(2);
        existingClassroom.setTeacher(teacher);
        existingClassroom.setStudent(studentList);

        Classroom updatedClassroom = new Classroom();
        Address updatedAddress = new Address();
        updatedAddress.setId(1);
        updatedAddress.setCity("Brno");
        updatedAddress.setStreet("Česká");
        updatedAddress.setStreetNumber(124);
        Teacher updatedTeacher = new Teacher();
        updatedTeacher.setTeacherid(1);
        updatedTeacher.setAge(38);
        updatedTeacher.setFirstname("Lukáš");
        updatedTeacher.setSalary(45000);
        updatedTeacher.setLastname("Samec");
        Student updatedStudent = new Student();
        updatedStudent.setId(1);
        updatedStudent.setAge(16);
        updatedStudent.setFirstname("Alan");
        updatedStudent.setLastname("Velký");
        updatedStudent.setAddress(address);
        List<Student> updatedStudentList = new ArrayList<>();
        updatedStudentList.add(student);
        updatedClassroom.setId(1);
        updatedClassroom.setName("c3d");
        updatedClassroom.setFloor(3);
        updatedClassroom.setTeacher(updatedTeacher);
        updatedClassroom.setStudent(updatedStudentList);

        when(classroomRepository.findById(1)).thenReturn(Optional.of(existingClassroom));

        when(classroomRepository.save(updatedClassroom)).thenReturn(updatedClassroom);

        Classroom result = classroomServiceImpl.updateClassroom(1, updatedClassroom);

        assertNotNull(result);
        assertEquals(updatedClassroom.getFloor(), result.getFloor());
        assertEquals(updatedClassroom.getName(), result.getName());
        assertEquals(updatedClassroom.getStudent(), result.getStudent());
        verify(classroomRepository, times(1)).save(updatedClassroom);
    }

    @Test
    void deleteClassroom() {
        int classId = 1;

        classroomServiceImpl.deleteClassroom(classId);

        verify(classroomRepository, times(1)).deleteById(classId);
    }
}