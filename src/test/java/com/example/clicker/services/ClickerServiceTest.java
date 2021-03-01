package com.example.clicker.services;

import com.example.clicker.models.Clicker;
import com.example.clicker.repositories.ClickerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.expression.ExpressionException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClickerServiceTest {
    @MockBean
    private ClickerRepository clickerRepository;

    @Autowired
    ClickerService clickerService;

@Test
void whenClickerNotFound_thenThrowException(){

    Exception exception = assertThrows(ExpressionException.class, () -> clickerService.get());

    String expectedMessage = "Clicker not found!";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));

}

    @Test
    void whenGet_thenReturn() {
        Clicker clicker = new Clicker();
        clicker.setCount(0);
        clicker.setId((long) 1);

        when(clickerRepository.findById(any())).thenReturn(java.util.Optional.of(clicker));

        Clicker outputClicker = clickerService.get();
        assertEquals(outputClicker, clicker);
    }

    @Test
    void whenIncrementCount_thenReturn() {
        Clicker oldClicker = new Clicker();
        oldClicker.setCount(0);
        oldClicker.setId((long) 1);

        when(clickerRepository.findById(any())).thenReturn(java.util.Optional.of(oldClicker));
        when(clickerRepository.save(any())).thenReturn(oldClicker);

        Clicker outputClicker = clickerService.incrementCount();
        assertEquals(outputClicker.getId(), oldClicker.getId());
        assertEquals(outputClicker.getCount(), oldClicker.getCount());
    }
}