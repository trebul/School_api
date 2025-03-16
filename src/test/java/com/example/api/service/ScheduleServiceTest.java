package com.example.api.service;

import com.example.api.model.*;
import com.example.api.repository.ScheduleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ScheduleServiceTest {

    @Mock
    private ScheduleRepository scheduleRepository;

    @InjectMocks
    private ScheduleServiceImpl scheduleServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void createSchedule() throws ParseException {

        Subject subject = new Subject();
        subject.setSubjectName("Matika");
        subject.setId(1);
        subject.setEndOfSubject(LocalDate.parse("2024-11-08"));
        subject.setStartOfSubject(LocalDate.parse("2025-11-08"));
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject);
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
        Schedule schedule = new Schedule();
        schedule.setId(1);
        schedule.setSchoolYear("2023/2024");
        schedule.setClassroom(classroom);
        schedule.setSubject(subjects);
    }

    @Test
    void getAllSchedules() throws ParseException {
        Subject subject = new Subject();
        subject.setSubjectName("Matika");
        subject.setId(1);
        subject.setEndOfSubject(LocalDate.parse("2024-11-08"));
        subject.setStartOfSubject(LocalDate.parse("2025-11-08"));
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject);
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
        Schedule schedule = new Schedule();
        schedule.setId(1);
        schedule.setSchoolYear("2023/2024");
        schedule.setClassroom(classroom);
        schedule.setSubject(subjects);
    }

    @Test
    void getScheduleById() throws ParseException {
        Subject subject = new Subject();
        subject.setSubjectName("Matika");
        subject.setId(1);
        subject.setEndOfSubject(LocalDate.parse("2024-11-08"));
        subject.setStartOfSubject(LocalDate.parse("2025-11-08"));
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject);
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
        Schedule schedule = new Schedule();
        schedule.setId(1);
        schedule.setSchoolYear("2023/2024");
        schedule.setClassroom(classroom);
        schedule.setSubject(subjects);
    }

    @Test
    void updateSchedule() throws ParseException {
        Subject existingsubject = new Subject();
        existingsubject.setSubjectName("Matika");
        existingsubject.setId(1);
        existingsubject.setEndOfSubject(LocalDate.parse("2024-11-08"));
        existingsubject.setStartOfSubject(LocalDate.parse("2025-11-08"));
        List<Subject> existingSubjects = new ArrayList<>();
        existingSubjects.add(existingsubject);
        Classroom existingClassroom = new Classroom();
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
        List<Student> existingStudentList = new ArrayList<>();
        existingStudentList.add(existingStudent);
        existingClassroom.setId(1);
        existingClassroom.setName("c2d");
        existingClassroom.setFloor(2);
        existingClassroom.setTeacher(existingTeacher);
        existingClassroom.setStudent(existingStudentList);
        Schedule existingSchedule = new Schedule();
        existingSchedule.setId(1);
        existingSchedule.setSchoolYear("2023/2024");
        existingSchedule.setClassroom(existingClassroom);
        existingSchedule.setSubject(existingSubjects);

        Subject updatedSubject = new Subject();
        updatedSubject.setSubjectName("Čeština");
        updatedSubject.setId(1);
        updatedSubject.setEndOfSubject(LocalDate.parse("2023-11-08"));
        updatedSubject.setStartOfSubject(LocalDate.parse("2024-11-08"));
        List<Subject> updatedSubjects = new ArrayList<>();
        updatedSubjects.add(updatedSubject);
        Classroom updatedClassroom = new Classroom();
        Address updatedAddress = new Address();
        updatedAddress.setId(1);
        updatedAddress.setCity("Liberec");
        updatedAddress.setStreet("Karla IV.");
        updatedAddress.setStreetNumber(15);
        Teacher updatedTeacher = new Teacher();
        updatedTeacher.setTeacherid(1);
        updatedTeacher.setAge(48);
        updatedTeacher.setFirstname("Daniel");
        updatedTeacher.setSalary(46000);
        updatedTeacher.setLastname("Michálek");
        Student updatedStudent = new Student();
        updatedStudent.setId(1);
        updatedStudent.setAge(17);
        updatedStudent.setFirstname("Milan");
        updatedStudent.setLastname("Zelenka");
        updatedStudent.setAddress(updatedAddress);
        List<Student> updatedStudentList = new ArrayList<>();
        updatedStudentList.add(updatedStudent);
        updatedClassroom.setId(1);
        updatedClassroom.setName("c4d");
        updatedClassroom.setFloor(4);
        updatedClassroom.setTeacher(updatedTeacher);
        updatedClassroom.setStudent(updatedStudentList);
        Schedule updatedSchedule = new Schedule();
        updatedSchedule.setId(1);
        updatedSchedule.setSchoolYear("2024/2025");
        updatedSchedule.setClassroom(updatedClassroom);
        updatedSchedule.setSubject(updatedSubjects);

        when(scheduleRepository.findById(1)).thenReturn(Optional.of(existingSchedule));
        when(scheduleRepository.save(updatedSchedule)).thenReturn(updatedSchedule);

        Schedule result = scheduleServiceImpl.updateSchedule(1, updatedSchedule);

        assertNotNull(result);
        assertEquals(updatedSchedule.getSchoolYear(), result.getSchoolYear());
        assertEquals(updatedSchedule.getClassroom(), result.getClassroom());
        assertEquals(updatedSchedule.getSubject(), result.getSubject());
        verify(scheduleRepository, times(1)).save(updatedSchedule);
    }

    @Test
    void deleteSchedule() {
        int scheduleId = 1;

        scheduleServiceImpl.deleteSchedule(scheduleId);
        verify(scheduleRepository, times(1)).deleteById(scheduleId);
    }

    @Test
    void findBySchoolYear() throws ParseException {
        String schoolYear = "2023/2024";
        Subject subject = new Subject();
        subject.setSubjectName("Matika");
        subject.setId(1);
        subject.setEndOfSubject(LocalDate.parse("2024-11-08"));
        subject.setStartOfSubject(LocalDate.parse("2025-11-08"));
        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject);
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
        Schedule schedule1 = new Schedule();
        schedule1.setId(1);
        schedule1.setSchoolYear("2023/2024");
        schedule1.setClassroom(classroom);
        schedule1.setSubject(subjects);

        List<Schedule> schedules = new ArrayList<>();
        schedules.add(schedule1);

        when(scheduleRepository.findBySchoolYear(schoolYear)).thenReturn(schedules);

        List<Schedule> result = scheduleServiceImpl.findBySchoolYear(schoolYear);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(schedules, result);
        verify(scheduleRepository, times(1)).findBySchoolYear(schoolYear);

    }
}