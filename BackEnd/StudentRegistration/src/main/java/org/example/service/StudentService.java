package org.example.service;

import org.example.entity.StudentEntity;
import org.example.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void saveStudent(Student student);
    Optional<StudentEntity> getStudent(Long id);
    List<StudentEntity> getAllStudents();
}
