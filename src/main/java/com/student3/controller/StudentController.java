package com.student3.controller;

import com.student3.payload.StudentDto;
import com.student3.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //http://localhost:8080/api/student
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto dto){
        StudentDto stdDto = studentService.saveStudent(dto);
        return new ResponseEntity<>(stdDto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/student/1
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("this id is deleted"+id, HttpStatus.OK);
    }

    //http://localhost:8080/api/student/2
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id")long id, @RequestBody StudentDto dto){
       studentService.updateStudent(id, dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

}
