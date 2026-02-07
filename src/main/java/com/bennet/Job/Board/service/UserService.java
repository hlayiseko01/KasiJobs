package com.bennet.Job.Board.service;

import com.bennet.Job.Board.model.Job;
import com.bennet.Job.Board.model.User;
import com.bennet.Job.Board.repository.JobRepository;
import com.bennet.Job.Board.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    public List<User> getAllJUsers(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).
                orElseThrow(()->new RuntimeException("That User that does not exist"));
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user){
        User tobeupdatedUser = userRepository.findById(user.getUserId()).
                orElseThrow(()-> new RuntimeException("User not found"));

        tobeupdatedUser.setName(user.getName());
        tobeupdatedUser.setEmail(user.getEmail());
        tobeupdatedUser.setCity(user.getCity());

        userRepository.save(tobeupdatedUser);


    }

    public void deleteUser( Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }else {
            throw new RuntimeException("The User does not exist");
        }
    }

}
