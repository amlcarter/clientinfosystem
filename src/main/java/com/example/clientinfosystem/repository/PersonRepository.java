package com.example.clientinfosystem.repository;

import com.example.clientinfosystem.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}