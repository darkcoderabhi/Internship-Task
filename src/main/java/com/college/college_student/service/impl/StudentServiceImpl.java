package com.college.college_student.service.impl;

import com.college.college_student.exception.IdNotFound;
import com.college.college_student.payload.dto.StudentDto;
import com.college.college_student.payload.entity.Student;
import com.college.college_student.repository.StudentRepo;
import com.college.college_student.service.StudentService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;
    Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);

    public StudentServiceImpl(StudentRepo studentRepo,ModelMapper modelMapper){
        this.studentRepo=studentRepo;
        this.modelMapper=modelMapper;
    }


    @Override
    public String saveStudent(StudentDto studentDto) {
        Student student=studentRepo.save(convertDtoToEntity(studentDto));
        logger.info("details added for student: {}",studentDto.getName());
        return "Details added and student id is "+student.getId();
    }

    @Override
    public List<StudentDto> getAllStudentDetails() {
        List<Student> students=studentRepo.findAll();
        return students.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return convertEntityToDto(studentRepo.findById(id).orElseThrow(()->new IdNotFound("Student not exist with id "+id)));

    }

    private Student convertDtoToEntity(StudentDto studentDto){
        return modelMapper.map(studentDto,Student.class);
    }

    private StudentDto convertEntityToDto(Student student){
        return modelMapper.map(student,StudentDto.class);
    }
}
