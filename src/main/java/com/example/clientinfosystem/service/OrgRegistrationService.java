package com.example.clientinfosystem.service;

import com.example.clientinfosystem.model.OrgRegistration;
import com.example.clientinfosystem.repository.OrgRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrgRegistrationService {
    @Autowired
    private OrgRegistrationRepository orgRegistrationRepository;

    public List<OrgRegistration> findAll() {
        return orgRegistrationRepository.findAll();
    }

    public Optional<OrgRegistration> findById(Long id) {
        return orgRegistrationRepository.findById(id);
    }

    public OrgRegistration save(OrgRegistration orgRegistration) {
        return orgRegistrationRepository.save(orgRegistration);
    }

    public void deleteById(Long id) {
        orgRegistrationRepository.deleteById(id);
    }
}