package com.example.api.service;

import com.example.api.model.Grades;

import java.util.List;

public interface GradesService {

    /**
     * Creates a new grade.
     *
     * @param grades the grade to be created
     * @return the created grade
     */
    Grades createGrades(Grades grades);

    /**
     * Retrieves a list of all grades.
     *
     * @return a list of all grades
     */
    List<Grades> getAllGrades();

    /**
     * Retrieves a specific grade by its ID.
     *
     * @param id the ID of the grade to retrieve
     * @return the grade with the specified ID, or {@code null} if not found
     */
    Grades getGradesById(int id);

    /**
     * Updates a specific grade identified by its ID.
     *
     * @param id the ID of the grade to update
     * @param grades the updated grade details
     * @return the updated grade
     */
    Grades updateGrades(int id, Grades grades);

    /**
     * Deletes a specific grade identified by its ID.
     *
     * @param id the ID of the grade to delete
     */
    void deleteGrades(int id);

    List<Grades> getStudentGrades(int id);
}
