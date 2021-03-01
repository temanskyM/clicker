package com.example.clicker.controllers;

import com.example.clicker.models.Clicker;
import com.example.clicker.services.ClickerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ApiController {
    private final AtomicInteger counter = new AtomicInteger();

    private final ClickerService clickerService;

    public ApiController(ClickerService clickerService) {
        this.clickerService = clickerService;
    }

    @GetMapping("/api/counter")
    public Clicker getClicker() {
        return clickerService.get();
    }
}
