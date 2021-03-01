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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
