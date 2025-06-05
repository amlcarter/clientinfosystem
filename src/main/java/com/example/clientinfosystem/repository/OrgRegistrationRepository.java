package com.example.clientinfosystem.repository;

import com.example.clientinfosystem.model.OrgRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRegistrationRepository extends JpaRepository<OrgRegistration, Long> {
}