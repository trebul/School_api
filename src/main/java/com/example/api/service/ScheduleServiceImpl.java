package com.example.api.service;

import com.example.api.model.Schedule;
import com.example.api.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule createSchedule (Schedule schedule) {
        Optional<Schedule> foundId = scheduleRepository.findById(schedule.getId());
        if(foundId.isEmpty()) {
            return scheduleRepository.save(schedule);
        }
        else {
            throw new IllegalStateException("Schedule already exists");
        }
    }

    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }
    public Schedule getScheduleById(int id){
        return scheduleRepository.findById(id).orElse(null);
    }

    public Schedule updateSchedule(int id, Schedule schedule) {
        Optional<Schedule> foundId = scheduleRepository.findById(schedule.getId());
        if(foundId.isPresent()) {
            schedule.setId(id);
            return scheduleRepository.save(schedule);
        }
        else {
            throw new IllegalStateException("Schedule not found");
        }
    }
    public void deleteSchedule(int id){
        scheduleRepository.deleteById(id);
    }

    public List<Schedule> findBySchoolYear(String schoolYear) {
        return scheduleRepository.findBySchoolYear(schoolYear);
    }
}
