package com.bennet.Job.Board.mapper;

import com.bennet.Job.Board.dto.JobRequestDTO;
import com.bennet.Job.Board.model.Job;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class JobReqDTOMapper implements Function<JobRequestDTO, Job> {
    @Override
    public Job apply(JobRequestDTO jobRequestDTO) {
        Job job = new Job();
        job.setTitle(jobRequestDTO.title());
        job.setDescription(jobRequestDTO.description());
        job.setRequirements(jobRequestDTO.requirements());
        job.setSalary(jobRequestDTO.salary());
        job.setStreet(jobRequestDTO.street());
        job.setSuburb(jobRequestDTO.suburb());
        job.setCity(jobRequestDTO.city());
        return job;
    }
}
