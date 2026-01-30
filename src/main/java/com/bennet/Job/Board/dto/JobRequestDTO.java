package com.bennet.Job.Board.dto;


import java.time.LocalDate;

public record JobRequestDTO(
        String title,
        String description,
        String requirements,
        Double salary,
        String street,
        String suburb,
        String city,
        Long employerId) {
}
