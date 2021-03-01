package com.example.clicker.controllers;

import com.example.clicker.models.Clicker;
import com.example.clicker.services.ClickerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ClickerService clickerService;

    @Autowired
    ApiController apiController;

    @Test
    void whenGetClicker_thenReturnStatus200() {
        Clicker clicker = new Clicker();
        clicker.setCount(0);
        clicker.setId((long) 1);
        when(clickerService.get()).thenReturn(clicker);

        ResponseEntity<Clicker> response = restTemplate.getForEntity("/api/clicker", Clicker.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getCount(), clicker.getCount());
        assertEquals(response.getBody().getId(), clicker.getId());
    }

    @Test
    void whenGetCounter_thenReturnStatus200() {
        Clicker clicker = new Clicker();
        clicker.setCount(0);
        clicker.setId((long) 1);
        when(clickerService.get()).thenReturn(clicker);

        ResponseEntity<Integer> response = restTemplate.getForEntity("/api/counter", Integer.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), clicker.getCount());
    }

    @Test
    void whenIncreaseCounter_thenReturnStatus200() {
        Clicker clicker = new Clicker();
        clicker.setCount(0);
        clicker.setId((long) 1);

        when(clickerService.incrementCount()).thenReturn(clicker);

        ResponseEntity<Clicker> response = restTemplate.postForEntity("/api/counter",null, Clicker.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getCount(), clicker.getCount());
        assertEquals(response.getBody().getId(), clicker.getId());
    }
}