package com.example.restApi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class addStudentRequestDto {
    @NotBlank(message = "Name is required")
    private String name;
    @Column(name = "cause_of_suicide")
    @Size(min=5, max=100 , message="Lame reason ")
    private String causeOfSuicide;
}
