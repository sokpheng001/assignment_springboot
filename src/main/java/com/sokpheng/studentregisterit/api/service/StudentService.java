package com.sokpheng.studentregisterit.api.service;

import com.sokpheng.studentregisterit.api.mapper.StudentManualMapper;
import com.sokpheng.studentregisterit.api.model.Student;
import com.sokpheng.studentregisterit.api.model.dto.CreateStudent;
import com.sokpheng.studentregisterit.api.model.dto.RespondStudent;
import com.sokpheng.studentregisterit.api.model.dto.UpdateStudent;
import com.sokpheng.studentregisterit.api.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<RespondStudent> getAllUsers(){
        List<RespondStudent> respondStudents = new ArrayList<>();
        studentRepository.findAll().forEach(student->{
            respondStudents.add(
                    StudentManualMapper.mapFromStudentToRespondStudent(student));
        });
        return respondStudents;
    }
    public RespondStudent registerStudent(CreateStudent createStudent){
        Student student = new Student(null, UUID.randomUUID().toString()
                , createStudent.name(), createStudent.email(), createStudent.password(), "", null);
        studentRepository.save(student);
        return StudentManualMapper.mapFromStudentToRespondStudent(student);
    }
    public Integer deletedStudentByUuid(String uuid){
        Student student = studentRepository.findStudentByUuid(uuid);
        if(student!=null){
            studentRepository.delete(student);
            return 1;
        }
        return 0;
    }
    @Transactional
    public RespondStudent updateStudentByUuid(String uuid, UpdateStudent student) {
        Student existingStudent = studentRepository.findStudentByUuid(uuid);
        if (existingStudent == null) {
            throw new RuntimeException("User not found");
        }

        BeanUtils.copyProperties(student, existingStudent, getNullPropertyNames(student));
        Student updatedStudent = studentRepository.save(existingStudent);

        return StudentManualMapper.mapFromStudentToRespondStudent(updatedStudent); // Convert to a response DTO
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        Set<String> emptyNames = new HashSet<>();

        for (var propertyDescriptor : wrappedSource.getPropertyDescriptors()) {
            Object value = wrappedSource.getPropertyValue(propertyDescriptor.getName());
            if (value == null) {
                emptyNames.add(propertyDescriptor.getName());
            }
        }
        return emptyNames.toArray(new String[0]);
    }

}
