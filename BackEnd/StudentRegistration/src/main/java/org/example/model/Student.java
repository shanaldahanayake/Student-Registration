package org.example.model;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private String age;
    private String contact;
    private String guardian;
    private String guardianAddress;
    private String guardianContact;
    private String image;
}
