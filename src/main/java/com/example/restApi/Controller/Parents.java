package com.example.restApi.Controller;

import com.example.restApi.Service.studentService;
import com.example.restApi.dto.addStudentRequestDto;
import com.example.restApi.dto.studentDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class Parents {

    private final studentService service;

    @GetMapping
    public ResponseEntity<List<studentDto>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<studentDto> getStudentsById(@PathVariable Long id) {

        return ResponseEntity.ok(service.getStudentsById(id));
    }

    @PostMapping
    public ResponseEntity<studentDto> createNewStudent(@RequestBody @Valid addStudentRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createNewStudent(dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        service.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<studentDto> replaceStudent(@PathVariable long id , @RequestBody @Valid addStudentRequestDto dto ){
        return ResponseEntity.ok(service.replaceStudent(id,dto));
    }
    @PatchMapping("{id}")
    public ResponseEntity<studentDto> updateStudent(@PathVariable long id , @RequestBody Map<String,Object> updates){
        return ResponseEntity.ok(service.updateStudent(id,updates));
    }
    //for accesing phone message try https://messages.google.com/web/- blocked by college wifi

    }




