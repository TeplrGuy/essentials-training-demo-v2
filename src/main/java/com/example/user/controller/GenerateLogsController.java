package com.example.user.controller;





import com.example.user.model.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.File;
import java.io.IOException;
import java.util.Optional;


@RestController
public class GenerateLogsController {
    public static final Logger LOG = LogManager.getLogger(GenerateLogsController.class);


    public GenerateLogsController(){

    }

    @GetMapping("/generate/{number}")
    public ResponseEntity getUser(@PathVariable Long number){

        for (int i = 0;i<number; i++) {
            LOG.info("Info level log message");
            LOG.debug("user");
            LOG.error("user");
        }

        return new ResponseEntity<>(
                "done generating logs",
                HttpStatus.OK);
    }



}
