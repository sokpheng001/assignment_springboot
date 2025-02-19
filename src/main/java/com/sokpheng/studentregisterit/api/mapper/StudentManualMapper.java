package com.sokpheng.studentregisterit.api.mapper;

import com.sokpheng.studentregisterit.api.model.Student;
import com.sokpheng.studentregisterit.api.model.dto.RespondStudent;

public class StudentManualMapper {
    public static RespondStudent mapFromStudentToRespondStudent(Student student){
        return                     RespondStudent.builder()
                .uuid(student.getUuid())
                .name(student.getName())
                .email(student.getEmail())
                .profile(student.getProfile())
                .build();
    }
}
