package com.student3.service;

import com.student3.payload.StudentDto;

public interface StudentService {
    StudentDto saveStudent(StudentDto dto);

    void deleteStudent(long id);

    void updateStudent(long id, StudentDto dto);
}
