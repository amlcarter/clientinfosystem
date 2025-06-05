package com.example.clientinfosystem.controller;

import com.example.clientinfosystem.model.OrgRegistration;
import com.example.clientinfosystem.service.OrgRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orgRegistrations")
public class OrgRegistrationController {
    @Autowired
    private OrgRegistrationService orgRegistrationService;

    @GetMapping
    public String listOrgRegistrations(Model model) {
        model.addAttribute("orgRegistrations", orgRegistrationService.findAll());
        return "orgRegistrations/list";
    }

    @GetMapping("/new")
    public String createOrgRegistrationForm(Model model) {
        model.addAttribute("orgRegistration", new OrgRegistration());
        return "orgRegistrations/form";
    }

    @PostMapping
    public String saveOrgRegistration(@ModelAttribute OrgRegistration orgRegistration) {
        orgRegistrationService.save(orgRegistration);
        return "redirect:/orgRegistrations";
    }

    @GetMapping("/edit/{id}")
    public String editOrgRegistrationForm(@PathVariable Long id, Model model) {
        model.addAttribute("orgRegistration", orgRegistrationService.findById(id).orElseThrow());
        return "orgRegistrations/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrgRegistration(@PathVariable Long id) {
        orgRegistrationService.deleteById(id);
        return "redirect:/orgRegistrations";
    }
}