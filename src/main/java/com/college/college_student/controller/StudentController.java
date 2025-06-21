package com.college.college_student.controller;

import com.college.college_student.payload.dto.StudentDto;
import com.college.college_student.repository.StudentRepo;
import com.college.college_student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService =studentService;
    }

    @PostMapping
    public ResponseEntity<String> saveStudent(@Valid @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.saveStudent(studentDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudentDetails(){
        return new ResponseEntity<>(studentService.getAllStudentDetails(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }
}
