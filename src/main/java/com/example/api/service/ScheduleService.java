package com.example.api.service;

import com.example.api.model.Schedule;

import java.util.List;

public interface ScheduleService {

    /**
     * Creates a new schedule.
     *
     * @param schedule the schedule to be created
     * @return the created schedule
     */
    public Schedule createSchedule(Schedule schedule);

    /**
     * Retrieves a list of all schedules.
     *
     * @return a list of all schedules
     */
    public List<Schedule> getAllSchedules();

    /**
     * Retrieves a specific schedule by its ID.
     *
     * @param id the ID of the schedule to retrieve
     * @return the schedule with the specified ID, or {@code null} if not found
     */
    public Schedule getScheduleById(int id);

    /**
     * Updates a specific schedule identified by its ID.
     *
     * @param id the ID of the schedule to update
     * @param schedule the updated schedule details
     * @return the updated schedule
     */
    public Schedule updateSchedule(int id, Schedule schedule);

    /**
     * Deletes a specific schedule identified by its ID.
     *
     * @param id the ID of the schedule to delete
     */
    public void deleteSchedule(int id);
}
