package com.example.clientinfosystem.controller;

import com.example.clientinfosystem.model.OrgLegForm;
import com.example.clientinfosystem.service.OrgLegFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orgLegForms")
public class OrgLegFormController {
    @Autowired
    private OrgLegFormService orgLegFormService;

    @GetMapping
    public String listOrgLegForms(Model model) {
        model.addAttribute("orgLegForms", orgLegFormService.findAll());
        return "orgLegForms/list";
    }

    @GetMapping("/new")
    public String createOrgLegFormForm(Model model) {
        model.addAttribute("orgLegForm", new OrgLegForm());
        return "orgLegForms/form";
    }

    @PostMapping
    public String saveOrgLegForm(@ModelAttribute OrgLegForm orgLegForm) {
        orgLegFormService.save(orgLegForm);
        return "redirect:/orgLegForms";
    }

    @GetMapping("/edit/{id}")
    public String editOrgLegFormForm(@PathVariable Long id, Model model) {
        model.addAttribute("orgLegForm", orgLegFormService.findById(id).orElseThrow());
        return "orgLegForms/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrgLegForm(@PathVariable Long id) {
        orgLegFormService.deleteById(id);
        return "redirect:/orgLegForms";
    }
}