package com.example.api.service;

import com.example.api.model.Exam;

import java.time.LocalDate;
import java.util.List;

public interface ExamService {
    /**
     * Creates a new exam.
     *
     * @param exam the exam to be created
     * @return the created eaxm
     */
    Exam createExam(Exam exam);

    /**
     * Retrieves a list of all exams.
     *
     * @return a list of all exams
     */
    List<Exam> getAllExams();

    /**
     * Retrieves a specific exam by its ID.
     *
     * @param id the ID of the exam to retrieve
     * @return the exam with the specified ID, or {@code null} if not found
     */
    Exam getExamById(int id);

    /**
     * Updates a specific exam identified by its ID.
     *
     * @param id the ID of the exam to update
     * @param exam the updated exam details
     * @return the updated exam
     */
    Exam updateExam(int id, Exam exam);

    /**
     * Deletes a specific exam identified by its ID.
     *
     * @param id the ID of the exam to delete
     */
    void deleteExam(int id);

    /** returns exams after specific date
     * @param date
     * @return exams after specific date
     */
    List<Exam> upcomingExams(LocalDate date);
}
