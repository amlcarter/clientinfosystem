package com.example.clientinfosystem.repository;

import com.example.clientinfosystem.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}