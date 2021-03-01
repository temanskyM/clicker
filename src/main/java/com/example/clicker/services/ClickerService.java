package com.example.clicker.services;

import com.example.clicker.models.Clicker;
import com.example.clicker.repositories.ClickerRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

@Service
public class ClickerService {
    ClickerRepository clickerRepository;

    public ClickerService(ClickerRepository clickerRepository) {
        this.clickerRepository = clickerRepository;
    }

    public Clicker get(){
        return clickerRepository.findById((long) 1).orElseThrow(()-> new ExpressionException("Clicker not found!"));
    }
}
