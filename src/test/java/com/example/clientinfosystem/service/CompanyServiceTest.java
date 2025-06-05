package com.example.clientinfosystem.service;

import com.example.clientinfosystem.model.Company;
import com.example.clientinfosystem.model.OrgLegForm;
import com.example.clientinfosystem.model.OrgRegistration;
import com.example.clientinfosystem.repository.CompanyRepository;
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
public class CompanyServiceTest {
    @Autowired
    private CompanyService companyService;

    @MockBean
    private CompanyRepository companyRepository;

    @Test
    void testFindAll() {
        Company company = new Company();
        company.setId(1L);
        company.setNameFull("ООО Ромашка");
        company.setNameShort("Ромашка");
        company.setNumberReg("1234567890");
        company.setDataReg(LocalDate.of(2023, 1, 15));
        company.setOgrRegistration(new OrgRegistration());
        company.setOrgLegForm(new OrgLegForm());

        when(companyRepository.findAll()).thenReturn(Arrays.asList(company));

        assertEquals(1, companyService.findAll().size());
        assertEquals("ООО Ромашка", companyService.findAll().get(0).getNameFull());
    }

    @Test
    void testFindById() {
        Company company = new Company();
        company.setId(1L);
        company.setNameFull("ООО Ромашка");
        company.setNameShort("Ромашка");
        company.setNumberReg("1234567890");
        company.setDataReg(LocalDate.of(2023, 1, 15));
        company.setOgrRegistration(new OrgRegistration());
        company.setOrgLegForm(new OrgLegForm());

        when(companyRepository.findById(1L)).thenReturn(Optional.of(company));

        assertTrue(companyService.findById(1L).isPresent());
        assertEquals("ООО Ромашка", companyService.findById(1L).get().getNameFull());
    }

    @Test
    void testSave() {
        Company company = new Company();
        company.setId(1L);
        company.setNameFull("ООО Ромашка");
        company.setNameShort("Ромашка");
        company.setNumberReg("1234567890");
        company.setDataReg(LocalDate.of(2023, 1, 15));

        when(companyRepository.save(any(Company.class))).thenReturn(company);

        Company savedCompany = companyService.save(company);
        assertEquals("ООО Ромашка", savedCompany.getNameFull());
    }

    @Test
    void testDeleteById() {
        companyService.deleteById(1L);
        verify(companyRepository, times(1)).deleteById(1L);
    }
}