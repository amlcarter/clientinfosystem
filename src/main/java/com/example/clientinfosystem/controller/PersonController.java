package com.example.clientinfosystem.controller;

import com.example.clientinfosystem.model.Person;
import com.example.clientinfosystem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping
    public String listPersons(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "persons/list";
    }

    @GetMapping("/new")
    public String createPersonForm(Model model) {
        model.addAttribute("person", new Person());
        return "persons/form";
    }

    @PostMapping
    public String savePerson(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/edit/{id}")
    public String editPersonForm(@PathVariable Long id, Model model) {
        model.addAttribute("person", personService.findById(id).orElseThrow());
        return "persons/form";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
        return "redirect:/persons";
    }
}