package com.example.api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "classroom")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int year;
    private int floor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_fk")
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_fk")
    private List<Student> student;
}
