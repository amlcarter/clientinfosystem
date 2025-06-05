package com.example.clientinfosystem.service;

import com.example.clientinfosystem.model.OrgLegForm;
import com.example.clientinfosystem.repository.OrgLegFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrgLegFormService {
    @Autowired
    private OrgLegFormRepository orgLegFormRepository;

    public List<OrgLegForm> findAll() {
        return orgLegFormRepository.findAll();
    }

    public Optional<OrgLegForm> findById(Long id) {
        return orgLegFormRepository.findById(id);
    }

    public OrgLegForm save(OrgLegForm orgLegForm) {
        return orgLegFormRepository.save(orgLegForm);
    }

    public void deleteById(Long id) {
        orgLegFormRepository.deleteById(id);
    }
}