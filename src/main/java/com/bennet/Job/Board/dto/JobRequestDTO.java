package com.bennet.Job.Board.dto;

import com.bennet.Job.Board.model.User;

import java.time.LocalDate;

public record JobRequestDTO(
        String title,
        String description,
        String requirements,
        Double salary,
        String street,
        String suburb,
        String city,
        String employerName,
        User employer) {
}
