package com.example.api.service;

import com.example.api.model.Subject;

import java.util.List;

public interface SubjectService {

    /**
     * Creates a new subject.
     *
     * @param subject the subject to be created
     * @return the created subject
     */
    public Subject createSubject(Subject subject);

    /**
     * Retrieves a list of all subjects.
     *
     * @return a list of all subjects
     */
    public List<Subject> getAllSubjects();

    /**
     * Retrieves a specific subject by its ID.
     *
     * @param id the ID of the subject to retrieve
     * @return the subject with the specified ID, or {@code null} if not found
     */
    public Subject getSubjectById(int id);

    /**
     * Updates a specific subject identified by its ID.
     *
     * @param id the ID of the subject to update
     * @param subject the updated subject details
     * @return the updated subject
     */
    public Subject updateSubject(int id, Subject subject);

    /**
     * Deletes a specific subject identified by its ID.
     *
     * @param id the ID of the subject to delete
     */
    public void deleteSubject(int id);
}
