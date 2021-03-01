package com.example.clicker.controllers;

import com.example.clicker.models.Clicker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void whenGetHome_ReturnStatus200() {
        ResponseEntity<Clicker> response = restTemplate.getForEntity("/", null);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}