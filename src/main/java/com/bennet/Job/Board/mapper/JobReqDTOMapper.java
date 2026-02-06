package com.bennet.Job.Board.mapper;

import com.bennet.Job.Board.dto.JobRequestDTO;
import com.bennet.Job.Board.model.Job;

import java.util.function.Function;

public class JobReqDTOMapper implements Function<JobRequestDTO, Job> {
    @Override
    public Job apply(JobRequestDTO jobRequestDTO) {
        Job job = new Job();
        job.setTitle(jobRequestDTO.title());
        return job;
    }
}
