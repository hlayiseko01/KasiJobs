package com.bennet.Job.Board.repository;

import com.bennet.Job.Board.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
