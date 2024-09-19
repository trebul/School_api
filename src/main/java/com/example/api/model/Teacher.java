package com.example.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "teacher")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherid;
   private String firstname;
   private String lastname;
   private int age;
   private int salary;

   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "teacher_id")
   private List<Student> students;
}
