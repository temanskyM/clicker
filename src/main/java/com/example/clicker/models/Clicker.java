package com.example.clicker.models;


import javax.persistence.*;

@Entity
public class Clicker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "count", nullable = false)
    private Integer count;

    public Clicker() {
    }

    public Clicker(Integer count) {
        this.count = count;
    }
}
