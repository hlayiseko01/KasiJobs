package com.bennet.Job.Board.service;

import com.bennet.Job.Board.dto.JobRequestDTO;
import com.bennet.Job.Board.dto.JobResponseDTO;
import com.bennet.Job.Board.mapper.JobReqDTOMapper;
import com.bennet.Job.Board.mapper.JobResDTOMapper;
import com.bennet.Job.Board.model.Job;
import com.bennet.Job.Board.model.User;
import com.bennet.Job.Board.repository.JobRepository;
import com.bennet.Job.Board.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobService {
    private final JobRepository jobRepository;
    private final JobResDTOMapper jobResDTOMapper;
    private final JobReqDTOMapper jobReqDTOMapper;
    private final UserRepository userRepository;


    JobService(JobRepository jobrepository, JobResDTOMapper jobResDTOMapper, JobReqDTOMapper jobReqDTOMapper, UserRepository userRepository){
        this.jobRepository=jobrepository;
        this.jobResDTOMapper=jobResDTOMapper;
        this.jobReqDTOMapper = jobReqDTOMapper;
        this.userRepository = userRepository;
    }

    public List<JobResponseDTO> getAllJobs(){
        return jobRepository.findAll().stream().map(jobResDTOMapper
        ).toList();
    }

    public JobResponseDTO findById(Integer id){
        return jobRepository.findById(id).map(jobResDTOMapper).
                orElseThrow(()->new RuntimeException("That job that does not exist"));
    }

   public void saveJob(JobRequestDTO jobRequestDTO){

       User employer = userRepository.findById(Math.toIntExact(jobRequestDTO.employerId()))
               .orElseThrow(() -> new RuntimeException("Employer not found"));

       Job job = jobReqDTOMapper.apply(jobRequestDTO);


       job.setEmployer(employer);

       jobRepository.save(job);;
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
