package com.example.api.repository;


import com.example.api.model.Schedule;
import com.example.api.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    public List<Schedule> findBySchoolYear(String schoolYear);
}
