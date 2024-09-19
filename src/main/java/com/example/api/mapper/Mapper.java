package com.example.api.mapper;

import com.example.api.model.Address;
import com.example.api.model.AddressDTO;
import com.example.api.model.Student;
import com.example.api.model.StudentDTO;
import com.example.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    StudentService studentService;
    public StudentDTO toDto (Student student) {
        String firstname = student.getFirstname();
        String lastname = student.getLastname();
        int age = student.getAge();
        AddressDTO address = this.toDto(student.getAddress());

        return  new StudentDTO(firstname, lastname, age, address);
    }

    public StudentDTO getStudent(int id){
        Student student = studentService.getStudentById(id);
        String firstname = student.getFirstname();
        String lastname = student.getLastname();
        int age = student.getAge();
        AddressDTO addressDTO = this.toDto(student.getAddress());

        return  new StudentDTO(firstname, lastname, age, addressDTO);
    }

    public AddressDTO toDto (Address address) {
        String city = address.getCity();
        String street = address.getStreet();
        int streetNumber = address.getStreetNumber();

        return  new AddressDTO(city, street, streetNumber);
    }
}
