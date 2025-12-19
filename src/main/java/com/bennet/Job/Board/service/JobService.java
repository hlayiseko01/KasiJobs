package com.bennet.Job.Board.service;

import com.bennet.Job.Board.model.Job;
import com.bennet.Job.Board.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;


    JobService(JobRepository jobrepository){
        this.jobRepository=jobrepository;
    }

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    public Job findById(Integer id){
        return jobRepository.findById(id).
                orElseThrow(()->new RuntimeException("That job that does not exist"));
    }

   public void saveJob(Job job){
        jobRepository.save(job);
   }

   public void updateJob(Job job){
        Job tobeupdatedjob = jobRepository.findById(job.getJobId()).
                orElseThrow(()-> new RuntimeException("The Job does not exist"));

        tobeupdatedjob.setTitle(job.getTitle());
        tobeupdatedjob.setDescription(job.getDescription());
        tobeupdatedjob.setRequirements(job.getRequirements());
        tobeupdatedjob.setSalary(job.getSalary());
        tobeupdatedjob.setStreet(job.getStreet());
        tobeupdatedjob.setSuburb(job.getSuburb());
        tobeupdatedjob.setCity(job.getCity());

       jobRepository.save(tobeupdatedjob);

   }

   public void deleteJob( Integer id){
        if(jobRepository.existsById(id)){
            jobRepository.deleteById(id);
        }else {
            throw new RuntimeException("The job does not exist");
        }
   }

}
