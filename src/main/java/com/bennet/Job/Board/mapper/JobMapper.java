package com.bennet.Job.Board.mapper;

import com.bennet.Job.Board.dto.JobRequestDTO;
import com.bennet.Job.Board.dto.JobResponseDTO;
import com.bennet.Job.Board.model.Job;
import com.bennet.Job.Board.model.User;

import java.time.LocalDate;

public class JobMapper {
    public static Job toEntity (JobRequestDTO dto , User employer){
        return Job.builder()
                .title(dto.title())
                .description(dto.description())
                .requirements(dto.requirements())
                .salary(dto.salary())
                .street(dto.street())
                .suburb(dto.suburb())
                .city(dto.city())
                .employer(employer)
                .postedAt(LocalDate.now())
                .build();
    }

    public static JobResponseDTO toResponse(Job job){
        return  new JobResponseDTO(
                job.getTitle(),
                job.getDescription(),
                job.getRequirements(),
                job.getSalary(),
                job.getStreet(),
                job.getSuburb(),
                job.getCity(),
                job.getPostedAt());
    }
}
