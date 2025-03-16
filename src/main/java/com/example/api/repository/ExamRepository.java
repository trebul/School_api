package com.example.api.repository;

import com.example.api.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Integer> {

    @Query("SELECT e FROM Exam e WHERE e.examDate > :date")
    List<Exam> getExamsAfterDate(LocalDate date);
}
