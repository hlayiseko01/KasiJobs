package com.bennet.Job.Board.repository;

import com.bennet.Job.Board.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Integer> {
}
