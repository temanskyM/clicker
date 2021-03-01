package com.example.clicker.repositories;

import com.example.clicker.models.Clicker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickerRepository extends CrudRepository<Clicker, Long> {
    boolean countById(Long i);
}
