package com.sokpheng.studentregisterit.api.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "courses")
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String courseName;
    private String courseCode;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    // Getters and Setters
}
