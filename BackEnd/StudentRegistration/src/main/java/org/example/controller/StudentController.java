package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.StudentEntity;
import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    final StudentService studentService;

    Student std=new Student();

    @PostMapping("/save")
    Map<String, String> saveStudent(@RequestPart("name") String name,
                                    @RequestPart("age") String age,
                                    @RequestPart("contact") String contact,
                                    @RequestPart("guardian") String guardian,
                                    @RequestPart("guardianAddress") String guardianAddress,
                                    @RequestPart("guardianContact") String guardianContact,
                                    @RequestPart("file") MultipartFile file){

        std.setName(name);
        std.setAge(age);
        std.setContact(contact);
        std.setGuardian(guardian);
        std.setGuardianAddress(guardianAddress);
        std.setGuardianContact(guardianContact);

        try{
            std.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        }catch(Exception e){
            e.printStackTrace();
        }

        studentService.saveStudent(std);

        return Collections.singletonMap("Status","Status Success");
    }

    @GetMapping("/getAll")
    public List<StudentEntity> getAllStudents(){

        return studentService.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Optional<StudentEntity> getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }
}
