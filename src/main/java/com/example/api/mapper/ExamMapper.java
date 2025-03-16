package com.example.api.mapper;

import com.example.api.model.Exam;
import com.example.api.model.ExamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamMapper {

    @Mapping(source = "subject", target = "subject")
    ExamDTO examToExamDTO(Exam exam);
    Exam toExam(ExamDTO examDTO);
}
