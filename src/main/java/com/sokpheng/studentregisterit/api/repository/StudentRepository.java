package com.sokpheng.studentregisterit.api.repository;

import com.sokpheng.studentregisterit.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findStudentByUuid(String uuid);
}
