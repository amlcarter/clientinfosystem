package com.example.clientinfosystem.service;

import com.example.clientinfosystem.model.Person;
import com.example.clientinfosystem.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PersonServiceTest {
    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;

    @Test
    void testFindAll() {
        Person person = new Person();
        person.setId(1L);
        person.setShifer("SHF001");
        person.setInn("123456789012");
        person.setType(Person.PersonType.PHYSICAL);
        person.setData(LocalDate.now());

        when(personRepository.findAll()).thenReturn(Arrays.asList(person));

        assertEquals(1, personService.findAll().size());
        assertEquals("SHF001", personService.findAll().get(0).getShifer());
    }

    @Test
    void testFindById() {
        Person person = new Person();
        person.setId(1L);
        person.setShifer("SHF001");
        person.setInn("123456789012");
        person.setType(Person.PersonType.PHYSICAL);
        person.setData(LocalDate.now());

        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        assertTrue(personService.findById(1L).isPresent());
        assertEquals("SHF001", personService.findById(1L).get().getShifer());
    }
}