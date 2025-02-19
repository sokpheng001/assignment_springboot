package com.sokpheng.studentregisterit.api.controller;

import com.sokpheng.studentregisterit.api.model.dto.CreateStudent;
import com.sokpheng.studentregisterit.api.model.dto.UpdateStudent;
import com.sokpheng.studentregisterit.api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;
    @GetMapping("")
    public ResponseEntity<Object> getAllStudents(){
            return ResponseEntity.ok(service.getAllUsers());
    }
    @PostMapping("")
    public ResponseEntity<Object> registerStudent(@RequestBody CreateStudent createStudent){
        return ResponseEntity.ok(service.registerStudent(createStudent));
    }
    @DeleteMapping("{uuid}")
    public ResponseEntity<Object> deleteStudentByUuid(@PathVariable String uuid){
        return ResponseEntity.ok(service.deletedStudentByUuid(uuid));
    }
    @PutMapping("{uuid}")
    public ResponseEntity<Object> updateStudentByUuid(@PathVariable String uuid, @RequestBody UpdateStudent updateStudent){
        return ResponseEntity.ok(service.updateStudentByUuid(uuid, updateStudent));
    }
}
