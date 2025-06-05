package com.example.clientinfosystem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "org_leg_form")
public class OrgLegForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameFull;

    @Column(nullable = false)
    private String nameShort;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNameFull() { return nameFull; }
    public void setNameFull(String nameFull) { this.nameFull = nameFull; }
    public String getNameShort() { return nameShort; }
    public void setNameShort(String nameShort) { this.nameShort = nameShort; }
}