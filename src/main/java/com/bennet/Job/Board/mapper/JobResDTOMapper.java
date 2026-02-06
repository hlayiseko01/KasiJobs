package com.bennet.Job.Board.mapper;

import com.bennet.Job.Board.dto.JobResponseDTO;
import com.bennet.Job.Board.model.Job;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Component
public class JobResDTOMapper implements Function<Job, JobResponseDTO> {
    @Override
    public JobResponseDTO apply(Job job) {
        return new JobResponseDTO(
                job.getTitle(),
                job.getDescription(),
                job.getRequirements(),
                job.getSalary(),
                job.getStreet(),
                job.getSuburb(),
                job.getCity(),
                job.getPostedAt()
        );
    }
}
