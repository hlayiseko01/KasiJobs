package com.bennet.Job.Board.controller;

import com.bennet.Job.Board.service.UserService;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.web.bind.annotation.RestController;

@RestController("users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService){
        this.userService=userService;
    }


}
