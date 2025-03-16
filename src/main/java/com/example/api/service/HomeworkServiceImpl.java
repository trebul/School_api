package com.example.api.service;

import com.example.api.model.Homework;
import com.example.api.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeworkServiceImpl implements HomeworkService{
    @Autowired
    private HomeworkRepository homeworkRepository;
    /**
     * Retrieves all homeworks
     *
     * @return list of all homeworks
     */
    @Override
    public List<Homework> getAllHomeworks() {
        return homeworkRepository.findAll();
    }

    /**
     * Retrieves a specific homework by its ID.
     *
     * @param id the ID of the homework to retrieve
     * @return the homework with the specified ID, or {@code null} if not found
     */
    @Override
    public Homework getHomeworkById(int id) {
        return homeworkRepository.findById(id).orElse(null);
    }

    /**
     * Creates homework
     *
     * @param homework the homework to be created
     * @return the created homework
     */
    @Override
    public Homework createHomework(Homework homework) {
        return homeworkRepository.save(homework);
    }

    /**
     * Updates a specific homework identified by its ID.
     *
     * @param id       the ID of the homework to retrieve
     * @param homework the updated homework details
     * @return the updated homework
     */
    @Override
    public Homework updateHomework(int id, Homework homework) {
        Optional<Homework> foundHomework = homeworkRepository.findById(id);
        if(foundHomework.isPresent()) {
            homework.setId(id);
            return homeworkRepository.save(homework);
        }
        else {
            throw new IllegalStateException("Homework not found");
        }
    }

    /**
     * Deletes a specific homework identified by its ID.
     *
     * @param id the ID of the homework to delete
     */
    @Override
    public void deleteHomework(int id) {
        homeworkRepository.deleteById(id);
    }
}
