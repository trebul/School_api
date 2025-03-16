package com.example.api.service;

import com.example.api.model.Subject;
import com.example.api.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject createSubject (Subject subject) {
        Optional<Subject> foundId = subjectRepository.findById(subject.getId());
        if(foundId.isEmpty()) {
            return subjectRepository.save(subject);
        }
        else {
            throw new IllegalStateException("Subject already exists");
        }
    }

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }
    public Subject getSubjectById(int id){
        return subjectRepository.findById(id).orElse(null);
    }

    public Subject updateSubject(int id, Subject subject) {
        Optional<Subject> foundId = subjectRepository.findById(subject.getId());
        if(foundId.isPresent()) {
            subject.setId(id);
            return subjectRepository.save(subject);
        }
        else {
            throw new IllegalStateException("Subject not found");
        }
    }

    public void deleteSubject(int id){
        subjectRepository.deleteById(id);
    }
}
