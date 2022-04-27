package com.example.user.controller;



import com.example.user.model.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.File;
import java.io.IOException;
import java.util.Optional;


@RestController
public class UserController {
    public static final Logger LOG = LogManager.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    public UserController(){

    }

    @PostMapping("/users")
    public void registerUser(@RequestBody User user){

        LOG.info("Info level log message");
        LOG.debug("user");
        LOG.error("user");
        userService.addUser(user);
    }

    @GetMapping("{userId}")
    public Optional<User> getUser(@PathVariable Long userId){

        LOG.info("Info level log message");
        LOG.debug("user");
        LOG.error("user");

        Optional<User> currentUser = userService.getUserById(userId);
        return currentUser;
    }


    @PutMapping("/upload")
    public String uploadFile(@RequestParam("myFile") MultipartFile multipartFile) {
        try {
            multipartFile.transferTo(new File("C:\\home\\" + "picture.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
