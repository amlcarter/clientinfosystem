package com.example.clientinfosystem.controller;

import com.example.clientinfosystem.model.Company;
import com.example.clientinfosystem.service.CompanyService;
import com.example.clientinfosystem.service.OrgLegFormService;
import com.example.clientinfosystem.service.OrgRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private OrgRegistrationService orgRegistrationService;

    @Autowired
    private OrgLegFormService orgLegFormService;

    @GetMapping
    public String listCompanies(Model model) {
        model.addAttribute("companies", companyService.findAll());
        return "companies/list";
    }

    @GetMapping("/new")
    public String createCompanyForm(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("orgRegistrations", orgRegistrationService.findAll());
        model.addAttribute("orgLegForms", orgLegFormService.findAll());
        return "companies/form";
    }

    @PostMapping
    public String saveCompany(@ModelAttribute Company company) {
        companyService.save(company);
        return "redirect:/companies";
    }

    @GetMapping("/edit/{id}")
    public String editCompanyForm(@PathVariable Long id, Model model) {
        model.addAttribute("company", companyService.findById(id).orElseThrow());
        model.addAttribute("orgRegistrations", orgRegistrationService.findAll());
        model.addAttribute("orgLegForms", orgLegFormService.findAll());
        return "companies/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id) {
        companyService.deleteById(id);
        return "redirect:/companies";
    }
}