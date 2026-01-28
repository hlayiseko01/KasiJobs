package com.bennet.Job.Board.dto;

import com.bennet.Job.Board.model.UserType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record UserRequestDTO(
        String name,
        String email,
        String password,
        String city,
        UserType userType) {
}
