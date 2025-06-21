package com.college.college_student.service;

import com.college.college_student.payload.dto.StudentDto;
import java.util.List;

public interface StudentService {
    String saveStudent(StudentDto studentDto);

    List<StudentDto> getAllStudentDetails();

    StudentDto getStudentById(Long id);
}
