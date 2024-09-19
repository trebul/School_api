package com.example.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String firstname;
    private String lastname;
    private int age;
    private AddressDTO addressDTO;
}
