package com.example.api.service;

import com.example.api.mapper.StudentMapper;
import com.example.api.model.Address;
import com.example.api.model.AddressDTO;
import com.example.api.model.Student;
import com.example.api.model.StudentDTO;
import com.example.api.repository.StudentRepository;
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

class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentServiceImpl studentServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void createStudent() {
        Student student = new Student();
        Address address = new Address();
        address.setId(1);
        address.setCity("Plzeň");
        address.setStreet("Moravská");
        address.setStreetNumber(154);
        student.setId(1);
        student.setAge(16);
        student.setFirstname("Michal");
        student.setLastname("Malý");
        student.setAddress(address);

        when(studentRepository.save(student)).thenReturn(student);

        Student result = studentServiceImpl.createStudent(student);

        assertNotNull(result);
        assertEquals(student, result);
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void getAllStudents() {
        Student student = new Student();
        Address address = new Address();
        address.setId(1);
        address.setCity("Plzeň");
        address.setStreet("Moravská");
        address.setStreetNumber(154);
        student.setId(1);
        student.setAge(16);
        student.setFirstname("Michal");
        student.setLastname("Malý");
        student.setAddress(address);

        when(studentRepository.findAll()).thenReturn(Collections.singletonList(student));

        List<Student> students = studentServiceImpl.getAllStudents();
        assertNotNull(students);
        assertEquals(1, students.size());
        assertEquals(student, students.get(0));

        verify(studentRepository, times(1)).findAll();
    }
    @Test
    void getStudentById() {
        // Arrange
        Student student = new Student();
        student.setId(1);
        student.setAge(16);
        student.setFirstname("Michal");
        student.setLastname("Malý");

        Address address = new Address();
        address.setCity("Plzeň");
        address.setStreet("Moravská");
        address.setStreetNumber(154);
        student.setAddress(address);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setAge(16);
        studentDTO.setFirstname("Michal");
        studentDTO.setLastname("Malý");

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("Plzeň");
        addressDTO.setStreet("Moravská");
        addressDTO.setStreetNumber(154);
        studentDTO.setAddressDTO(addressDTO);

        when(studentRepository.findById(1)).thenReturn(Optional.of(student));
        when(studentMapper.studentToStudentDTO(student)).thenReturn(studentDTO);

        StudentDTO result = studentServiceImpl.getStudentById(1);

        assertNotNull(result);
        assertNotNull(result.getAddressDTO());
        assertEquals("Michal", result.getFirstname());
        assertEquals("Malý", result.getLastname());
        assertEquals(16, result.getAge());
        assertEquals("Plzeň", result.getAddressDTO().getCity());
        assertEquals("Moravská", result.getAddressDTO().getStreet());
        assertEquals(154, result.getAddressDTO().getStreetNumber());

        verify(studentRepository, times(1)).findById(1);
    }
    @Test
    void updateStudent() {
        Student existingStudent = new Student();
        Address existingAddress = new Address();
        existingAddress.setId(1);
        existingAddress.setCity("Plzeň");
        existingAddress.setStreet("Moravská");
        existingAddress.setStreetNumber(154);
        existingStudent.setId(1);
        existingStudent.setAge(16);
        existingStudent.setFirstname("Michal");
        existingStudent.setLastname("Malý");
        existingStudent.setAddress(existingAddress);

        Student updatedStudent = new Student();
        Address updatedAddress = new Address();
        updatedAddress.setId(1);
        updatedAddress.setCity("Plzeň");
        updatedAddress.setStreet("Moravská");
        updatedAddress.setStreetNumber(154);
        updatedStudent.setId(1);
        updatedStudent.setAge(16);
        updatedStudent.setFirstname("Michal");
        updatedStudent.setLastname("Malý");
        updatedStudent.setAddress(updatedAddress);

        when(studentRepository.findById(1)).thenReturn(Optional.of(existingStudent));

        when(studentRepository.save(updatedStudent)).thenReturn(updatedStudent);

        Student result = studentServiceImpl.updateStudent(1, updatedStudent);

        assertNotNull(result);
        assertEquals(updatedStudent.getAge(), result.getAge());
        assertEquals(updatedStudent.getFirstname(), result.getFirstname());
        assertEquals(updatedStudent.getLastname(), result.getLastname());
        verify(studentRepository, times(1)).save(updatedStudent);
    }

    @Test
    void deleteStudent() {
        int studentId = 1;
        studentServiceImpl.deleteStudent(studentId);
        verify(studentRepository, times(1)).deleteById(studentId);
    }
}