package com.example.clicker.controllers;

import com.example.clicker.models.Clicker;
import com.example.clicker.services.ClickerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class ApiController {
    private final AtomicInteger counter = new AtomicInteger();

    ClickerService clickerService;

    public ApiController(ClickerService clickerService) {
        this.clickerService = clickerService;
    }

    @GetMapping("/api/counter")
    public Clicker getCount(Model model) {
        return clickerService.get();
    }
}
