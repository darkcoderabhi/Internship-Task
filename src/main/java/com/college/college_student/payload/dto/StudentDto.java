package com.college.college_student.payload.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    @NotNull
    private String name;
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    private String course;
    @NotNull
    private String year;
}
