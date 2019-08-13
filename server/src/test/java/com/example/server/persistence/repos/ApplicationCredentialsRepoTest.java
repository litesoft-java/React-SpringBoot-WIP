package com.example.server.persistence.repos;

import com.example.server.persistence.model.ApplicationCredentials;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationCredentialsRepoTest {

    @Autowired
    private ApplicationCredentialsRepo repo;

    @Test
    public void testIt() {
        assertNotNull(repo);

        ApplicationCredentials creds = repo.save(new ApplicationCredentials()
                .withApplicationName("XYZ")
                .withEncryptedUserName("Secret")
                .withEncryptedPassword("Pwd")
                .withUserId("Fred")
        );
        assertNotNull(creds);
        assertNotNull(creds.getId());

        Optional<ApplicationCredentials> optionalCreds = repo.findById(creds.getId());
        ApplicationCredentials creds2 = optionalCreds.get();
        assertEquals(creds, creds2);

        assertEquals("Fred", creds2.getUserId());
    }
}