package com.edu.cs554.airlinesreservationsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AgentPatchRequest {
    private final long passengerId;
    private final String firstName;
    private final String lastName;
    @JsonFormat(pattern = "YYYY-MM-dd")
    private final LocalDate dateOfBirth;
}