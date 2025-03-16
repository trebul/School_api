package com.example.api.service;

import com.example.api.model.Homework;

import java.util.List;

public interface HomeworkService {

    /**
     * Retrieves all homeworks
     *
     * @return list of all homeworks
     */
    List<Homework> getAllHomeworks();

    /**
     * Retrieves a specific homework by its ID.
     *
     * @param id the ID of the homework to retrieve
     * @return the homework with the specified ID, or {@code null} if not found
     */
    Homework getHomeworkById(int id);
    /**
     * Creates homework
     *
     * @param homework the homework to be created
     * @return the created homework
     */
    Homework createHomework(Homework homework);

    /**
     * Updates a specific homework identified by its ID.
     *
     * @param id the ID of the homework to retrieve
     * @param homework the updated homework details
     * @return the updated homework
     */
    Homework updateHomework(int id, Homework homework);

    /**
     * Deletes a specific homework identified by its ID.
     *
     * @param id the ID of the homework to delete
     */
    void deleteHomework(int id);
}
