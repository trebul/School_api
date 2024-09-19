package com.example.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_fk")
    private Address address;
}
