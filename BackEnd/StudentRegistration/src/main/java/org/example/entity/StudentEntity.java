package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Table(name = "Student")
@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String age;
    private String contact;
    private String guardian;
    private String guardianAddress;
    private String guardianContact;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
}
