package com.phosphene.rest;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import com.phosphene.rest.repository.UserRepository;
import com.phosphene.rest.models.User;
import com.phosphene.rest.models.Role;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.containsString;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest
@WebAppConfiguration
@ActiveProfiles("test")
public class SessionsControllerTest {
	
    @Autowired
    private EmbeddedWebApplicationContext server;
    @Autowired 
    private UserRepository repository;
    private User user;
    private Role role;
    private RestTemplate restTemplate =new TestRestTemplate();
    @Value("${local.server.port}")  
    int port;

    @Before
    public void setUp() {
        user = repository.findByEmail("dobbs@test.com");
        RestAssured.port = port;
    }

    @Test
    public void testCreateSession() {
        repository.save(user);
        String restString = String.format("/sessions");

        given().
            body("{\"sessions\":[{  \"email\" : \"dobbs@test.com\", \"password\" : \"password\"}]}").
            with().contentType(JSON).
            when().
            post(restString).
            then().
            body("sessions[0].email", equalTo("dobbs@test.com"));
        
    }

    @Test
    public void testPrintCreateSession() {
        String restString = String.format("/sessions");
        given().
            body("{\"sessions\":[{  \"email\" : \"dobbs@test.com\", \"password\" : \"password\"}]}").
            with().contentType(JSON).
            when().
            post(restString).
            then().
            log().all();
    }


}
