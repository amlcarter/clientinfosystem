package com.example.clientinfosystem.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String shifer;

    @Column(nullable = false, length = 12)
    private String inn;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PersonType type;

    @Column(nullable = false)
    private LocalDate data;

    public enum PersonType {
        PHYSICAL, LEGAL
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getShifer() { return shifer; }
    public void setShifer(String shifer) { this.shifer = shifer; }
    public String getInn() { return inn; }
    public void setInn(String inn) { this.inn = inn; }
    public PersonType getType() { return type; }
    public void setType(PersonType type) { this.type = type; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
}