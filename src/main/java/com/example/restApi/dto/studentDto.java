package com.example.restApi.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class studentDto {

    private long id;
    private String name;
    @Column(name = "cause_of_suicide")
    private String causeOfSuicide;




}
