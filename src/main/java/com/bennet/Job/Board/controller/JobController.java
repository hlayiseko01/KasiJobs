package com.bennet.Job.Board.controller;

import com.bennet.Job.Board.model.Job;
import com.bennet.Job.Board.service.JobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
