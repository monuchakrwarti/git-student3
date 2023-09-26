package com.student3.service;

import com.student3.entity.Student;
import com.student3.exception.SourceNotFound;
import com.student3.payload.StudentDto;
import com.student3.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper){
        this.studentRepository= studentRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public StudentDto saveStudent(StudentDto dto) {
        Student student = mapToEntity(dto);
        Student save = studentRepository.save(student);
        StudentDto studentDto = mapToDto(save);
        return studentDto;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(long id, StudentDto dto) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new SourceNotFound("this is not exist-:"+id)
        );
        Optional<Student> byId = studentRepository.findById(id);
        Student std = byId.get();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        studentRepository.save(student);

    }

    //dto to Entity
    public StudentDto mapToDto(Student student){
        StudentDto dto = modelMapper.map(student, StudentDto.class);
        return dto;
    }

    //Entity to dto
    public Student mapToEntity(StudentDto dto){
        Student student = modelMapper.map(dto, Student.class);
        return student;
    }
}
