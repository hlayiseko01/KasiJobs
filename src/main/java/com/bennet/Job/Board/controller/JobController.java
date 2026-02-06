package com.bennet.Job.Board.controller;

import com.bennet.Job.Board.dto.JobRequestDTO;
import com.bennet.Job.Board.dto.JobResponseDTO;
import com.bennet.Job.Board.model.Job;
import com.bennet.Job.Board.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jobs")
public class JobController {

private final JobService jobService;

     JobController(JobService jobService){
         this.jobService=jobService;
     }

     @GetMapping
    public List<JobResponseDTO> listAllJobs(){
         return jobService.getAllJobs();
     }

     @GetMapping("/{id}")
    public JobResponseDTO getJobById(@PathVariable Integer id){
         return jobService.findById(id);
     }

     @PostMapping
    public void saveJob(@RequestBody JobRequestDTO jobRequestDTO){
         jobService.saveJob(jobRequestDTO);
     }

     @PutMapping()
    public void update(Job job){
         jobService.updateJob(job);
     }

     @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Integer id){
         jobService.deleteJob(id);
     }


}
