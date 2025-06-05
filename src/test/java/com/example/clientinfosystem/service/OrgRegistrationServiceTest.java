package com.example.clientinfosystem.service;

import com.example.clientinfosystem.model.OrgRegistration;
import com.example.clientinfosystem.repository.OrgRegistrationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrgRegistrationServiceTest {
    @Autowired
    private OrgRegistrationService orgRegistrationService;

    @MockBean
    private OrgRegistrationRepository orgRegistrationRepository;

    @Test
    void testFindAll() {
        OrgRegistration orgRegistration = new OrgRegistration();
        orgRegistration.setId(1L);
        orgRegistration.setNameFull("Федеральная налоговая служба");
        orgRegistration.setNameShort("ФНС");

        when(orgRegistrationRepository.findAll()).thenReturn(Arrays.asList(orgRegistration));

        assertEquals(1, orgRegistrationService.findAll().size());
        assertEquals("ФНС", orgRegistrationService.findAll().get(0).getNameShort());
    }

    @Test
    void testFindById() {
        OrgRegistration orgRegistration = new OrgRegistration();
        orgRegistration.setId(1L);
        orgRegistration.setNameFull("Федеральная налоговая служба");
        orgRegistration.setNameShort("ФНС");

        when(orgRegistrationRepository.findById(1L)).thenReturn(Optional.of(orgRegistration));

        assertTrue(orgRegistrationService.findById(1L).isPresent());
        assertEquals("ФНС", orgRegistrationService.findById(1L).get().getNameShort());
    }

    @Test
    void testSave() {
        OrgRegistration orgRegistration = new OrgRegistration();
        orgRegistration.setId(1L);
        orgRegistration.setNameFull("Федеральная налоговая служба");
        orgRegistration.setNameShort("ФНС");

        when(orgRegistrationRepository.save(any(OrgRegistration.class))).thenReturn(orgRegistration);

        OrgRegistration savedOrgRegistration = orgRegistrationService.save(orgRegistration);
        assertEquals("ФНС", savedOrgRegistration.getNameShort());
    }

    @Test
    void testDeleteById() {
        orgRegistrationService.deleteById(1L);
        verify(orgRegistrationRepository, times(1)).deleteById(1L);
    }
}