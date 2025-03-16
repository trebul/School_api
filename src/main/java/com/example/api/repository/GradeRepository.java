package com.example.api.repository;

import com.example.api.model.Grades;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grades, Integer> {
    List<Grades> findByStudentId(Integer studentId);
}
