package com.bennet.Job.Board.controller;

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
    public List<Job> listAllJobs(){
         return jobService.getAllJobs();
     }

     @GetMapping("/{id}")
    public Job getJobById(@PathVariable Integer id){
         return jobService.findById(id);
     }

     @PostMapping
    public void saveJob(@RequestBody Job job){
         jobService.saveJob(job);
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
