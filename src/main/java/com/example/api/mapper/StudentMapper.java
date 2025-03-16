package com.example.api.mapper;

import com.example.api.model.Student;
import com.example.api.model.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

   @Mapping(source = "address", target = "addressDTO")
   StudentDTO studentToStudentDTO(Student student);
   Student toStudent(StudentDTO studentDTO);

}