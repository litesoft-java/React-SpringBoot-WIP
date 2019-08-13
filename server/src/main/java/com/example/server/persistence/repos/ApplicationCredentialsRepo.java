package com.example.server.persistence.repos;

import com.example.server.persistence.model.ApplicationCredentials;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationCredentialsRepo extends CrudRepository<ApplicationCredentials, Long> {
    List<ApplicationCredentials> findByUserId(String userId);
}
