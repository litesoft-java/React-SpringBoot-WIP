package com.example.server.controllers;

import com.example.server.persistence.model.ApplicationCredentials;
import com.example.server.persistence.repos.ApplicationCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class ApplicationCredentialsController {

    @Autowired
    private ApplicationCredentialsRepo repo;

    @GetMapping("/credentials/{userId}")
    public ResponseEntity<List<ApplicationCredentials>> getCredentials(@PathVariable String userId) {
        List<ApplicationCredentials> credentials = repo.findByUserId(userId);
        return new ResponseEntity<>(credentials, HttpStatus.OK);
    }

    @PostMapping("/credentials")
    public ResponseEntity<ApplicationCredentials> saveCredentials(@RequestBody ApplicationCredentials credentials) {

        ApplicationCredentials newCreds = repo.save(credentials);
        HttpStatus httpStatus = HttpStatus.CREATED;
        if (newCreds == null) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(newCreds, httpStatus);
    }
}
