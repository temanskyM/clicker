package com.example.clicker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class ApiController {
    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping("/api/counter")
    public Integer getCount(Model model) {
        return counter.get();
    }
}
