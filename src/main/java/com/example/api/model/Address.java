package com.example.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    private String street;

    private int streetNumber;

}
