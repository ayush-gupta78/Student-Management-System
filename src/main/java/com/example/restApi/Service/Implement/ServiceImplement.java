package com.example.restApi.Service.Implement;

import com.example.restApi.Entity.student;
import com.example.restApi.Repository.StudentRepository;
import com.example.restApi.Service.studentService;
import com.example.restApi.dto.addStudentRequestDto;
import com.example.restApi.dto.studentDto;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.jspecify.annotations.Nullable;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ServiceImplement implements studentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public studentDto replaceStudent(long id, addStudentRequestDto dto) {
        student Student= studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found with id "+id));
        modelMapper.map(dto,Student);
        Student=studentRepository.save(Student);
        return modelMapper.map(Student,studentDto.class);
    }

    @Override
    public studentDto getStudentsById(Long id) {
        student Student= studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found with id "+id));
        studentDto dto=modelMapper.map(Student,studentDto.class);
        return dto;
    }

    @Override
    public List<studentDto> getAllStudents() {
        List<student> students=studentRepository.findAll();
        List<studentDto> studentDtoList=students.stream().map(student -> new studentDto(student.getId(),student.getName(),student.getCauseOfSuicide())).toList();

        return studentDtoList;
    }

    @Override
    public  studentDto createNewStudent(addStudentRequestDto dto) {
        student newStudent=modelMapper.map(dto,student.class);
        student Student =studentRepository.save(newStudent);
        return modelMapper.map(Student,studentDto.class);
    }

    @Override
    public void deleteStudentById(long id) {
        if(!studentRepository.existsById(id))
            throw new IllegalArgumentException("Student with id "+id + "does not exist");

        studentRepository.deleteById(id);
    }

    @Override
    public studentDto updateStudent(long id, Map<String, Object> updates) {
        student Student= studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found with id "+id));
        updates.forEach((field, value)->{
            switch(field){
                case "name":
                    Student.setName((String) value);
                    break;
                case "causeOfSuicide":
                    Student.setCauseOfSuicide((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        student newStudent =studentRepository.save(Student);
        return modelMapper.map(newStudent,studentDto.class);
    }

}
