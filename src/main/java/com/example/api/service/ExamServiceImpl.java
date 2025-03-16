package com.example.api.service;

import com.example.api.model.Classroom;
import com.example.api.model.Exam;
import com.example.api.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamRepository examRepository;
    @Override
    public Exam createExam(Exam exam) {
        Optional<Exam> foundID = examRepository.findById(exam.getId());
        if(foundID.isEmpty()) {
            return examRepository.save(exam);
        }
        else {
            throw new IllegalStateException("Exam already exists");
        }
    }

    @Override
    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    @Override
    public Exam getExamById(int id) {
        return examRepository.findById(id).orElse(null);
    }

    @Override
    public Exam updateExam(int id, Exam exam) {
        Optional<Exam> foundID = examRepository.findById(id);
        if(foundID.isPresent()) {
            exam.setId(id);
            return examRepository.save(exam);
        }
        else {
            throw new IllegalStateException("Exam doesnt exist");
        }
    }

    @Override
    public void deleteExam(int id) {
        examRepository.deleteById(id);
    }

    @Override
    public List<Exam> upcomingExams(LocalDate date) {
        return examRepository.getExamsAfterDate(date);
    }
}
