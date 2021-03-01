package com.example.clicker.controllers;

import com.example.clicker.models.Clicker;
import com.example.clicker.services.ClickerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ApiController {
    private AtomicInteger counter = new AtomicInteger();

    private final ClickerService clickerService;

    public ApiController(ClickerService clickerService) {
        this.clickerService = clickerService;

        //Получаем текущее значение счетчика
        counter.set(clickerService.get().getCount());
    }

    @GetMapping("/api/clicker")
    public Clicker getClicker() {
        return clickerService.get();
    }

    @GetMapping("/api/counter")
    public Integer getCounter() {
        return counter.get();
    }


    @PreDestroy
    public void preDestroy() {//Перед тем как уничтожить бин, записываем значение в базу))
        clickerService.set(counter.get());
    }
}
