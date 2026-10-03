package com.example.restApi.Service;

import com.example.restApi.dto.addStudentRequestDto;
import com.example.restApi.dto.studentDto;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface studentService {

     studentDto replaceStudent(long id, addStudentRequestDto dto);

    studentDto getStudentsById(Long id);

    List<studentDto> getAllStudents();

    studentDto createNewStudent(addStudentRequestDto dto);

    void deleteStudentById(long id);

     studentDto updateStudent(long id, Map<String, Object> updates);
}
