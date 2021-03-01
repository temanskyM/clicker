package com.example.clicker.controllers;

import com.example.clicker.models.Clicker;
import com.example.clicker.services.ClickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final ClickerService clickerService;

    public ApiController(ClickerService clickerService) {
        this.clickerService = clickerService;
    }

    @GetMapping("/api/clicker")
    public Clicker getClicker() {
        return clickerService.get();
    }

    @GetMapping("/api/counter")
    public Integer getCounter() {
        return clickerService.get().getCount();
    }

    @PostMapping("/api/counter")
    public Clicker increaseCounter() {
        return  clickerService.incrementCount();
    }
}
