package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.entity.StudentEntity;
import org.example.model.Student;
import org.example.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    final Repository repository;
    final ObjectMapper mapper;

    @Override
    public void saveStudent(Student student) {
        StudentEntity entity=mapper.convertValue(student,StudentEntity.class);

        repository.save(entity);
    }

    @Override
    public Optional<StudentEntity> getStudent(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return (List<StudentEntity>) repository.findAll();
    }
}
