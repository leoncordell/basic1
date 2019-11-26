package com.simple.basicbootswaginmem.controllers;

import com.simple.basicbootswaginmem.db.User;
import com.simple.basicbootswaginmem.db.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    @DisplayName("Integration test which will get the actual output of text service")
    protected void doStuff() throws MalformedURLException {
        User user  = new User();
        user.setName("Tom");
        ResponseEntity<User> response = restTemplate.postForEntity(new URL("http://localhost:" + port + "/user").toString(),user,User.class);

                //(user,
                //new URL("http://localhost:" + port + "/user").toString(), String.class);
        assertEquals("Tom", response.getBody().getName());
    }

}