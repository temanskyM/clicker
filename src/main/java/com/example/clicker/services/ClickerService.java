package com.example.clicker.services;

import com.example.clicker.models.Clicker;
import com.example.clicker.repositories.ClickerRepository;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClickerService {
    ClickerRepository clickerRepository;

    public ClickerService(ClickerRepository clickerRepository) {
        this.clickerRepository = clickerRepository;

        //Проверяем на наличие кликера в базе
        if (!checkAvailabilityClicker())//Если его нет, то создаем
            createNewClicker();
    }

    public Clicker get() {
        return clickerRepository.findById((long) 1).orElseThrow(() -> new ExpressionException("Clicker not found!"));
    }

    @Transactional
    public Clicker incrementCount() {
        return clickerRepository.findById((long) 1).map(clicker -> {
            clicker.setCount(clicker.getCount() + 1);
            return clickerRepository.save(clicker);
        }).orElseThrow(() -> new ExpressionException("Clicker not found!"));
    }

    private boolean checkAvailabilityClicker() {
        return clickerRepository.count() == 1;
    }

    private void createNewClicker() {
        Clicker clicker = new Clicker(0);
        clickerRepository.save(clicker);
    }


}
