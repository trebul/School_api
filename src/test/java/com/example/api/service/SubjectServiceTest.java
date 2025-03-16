package com.example.api.service;

import com.example.api.model.Subject;
import com.example.api.repository.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SubjectServiceTest {
    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private SubjectServiceImpl subjectServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createSubject() throws ParseException {
        Subject subject = new Subject();
        subject.setSubjectName("Matika");
        subject.setId(1);
        subject.setEndOfSubject(LocalDate.parse("2024-11-08"));
        subject.setStartOfSubject(LocalDate.parse("2025-11-08"));

        when(subjectRepository.save(subject)).thenReturn(subject);

        Subject result = subjectServiceImpl.createSubject(subject);

        assertNotNull(result);
        assertEquals(subject, result);
        verify(subjectRepository, times(1)).save(subject);
    }

    @Test
    void getAllSubjects() throws ParseException {
        Subject subject = new Subject();
        subject.setSubjectName("Matika");
        subject.setId(1);
        subject.setEndOfSubject(LocalDate.parse("2024-11-08"));
        subject.setStartOfSubject(LocalDate.parse("2025-11-08"));

        when(subjectRepository.findAll()).thenReturn(Collections.singletonList(subject));

        List<Subject> subjects = subjectServiceImpl.getAllSubjects();
        assertNotNull(subjects);
        assertEquals(1, subjects.size());
        assertEquals(subject, subjects.get(0));

        verify(subjectRepository, times(1)).findAll();
    }

    @Test
    void getSubjectById() throws ParseException {
        Subject subject = new Subject();
        subject.setSubjectName("Matika");
        subject.setId(1);
        subject.setEndOfSubject(LocalDate.parse("2024-11-08"));
        subject.setStartOfSubject(LocalDate.parse("2025-11-08"));

        when(subjectRepository.findById(1)).thenReturn(Optional.of(subject));

        Subject result = subjectServiceImpl.getSubjectById(1);
        assertNotNull(result);
        assertEquals(subject, result);
        verify(subjectRepository, times(1)).findById(1);
    }

    @Test
    void updateSubject() throws ParseException {
        Subject existingSubject = new Subject();
        existingSubject.setSubjectName("Matika");
        existingSubject.setId(1);
        existingSubject.setEndOfSubject(LocalDate.parse("2024-11-08"));
        existingSubject.setStartOfSubject(LocalDate.parse("2025-11-08"));

        Subject updatedSubject = new Subject();
        updatedSubject.setSubjectName("Zeměpis");
        updatedSubject.setId(1);
        updatedSubject.setEndOfSubject(LocalDate.parse("2024-12-08"));
        updatedSubject.setStartOfSubject(LocalDate.parse("2025-12-08"));

        when(subjectRepository.findById(1)).thenReturn(Optional.of(existingSubject));

        when(subjectRepository.save(updatedSubject)).thenReturn(updatedSubject);

        Subject result = subjectServiceImpl.updateSubject(1, updatedSubject);

        assertNotNull(result);
        assertEquals(updatedSubject.getEndOfSubject(), result.getEndOfSubject());
        assertEquals(updatedSubject.getStartOfSubject(), result.getStartOfSubject());
        assertEquals(updatedSubject.getSubjectName(), result.getSubjectName());
        verify(subjectRepository, times(1)).save(updatedSubject);
    }

    @Test
    void deleteSubject() {
        int subjectId = 1;

        subjectServiceImpl.deleteSubject(subjectId);
        verify(subjectRepository, times(1)).deleteById(subjectId);
    }
}