package com.example.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "homework")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate deadline;

    @OneToOne
    @NotNull
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToOne
    @NotNull
    @JoinColumn(name = "class_id")
    private Classroom classroom;
}
