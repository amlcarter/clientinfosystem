package com.example.clientinfosystem.service;

import com.example.clientinfosystem.model.OrgLegForm;
import com.example.clientinfosystem.repository.OrgLegFormRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrgLegFormServiceTest {
    @Autowired
    private OrgLegFormService orgLegFormService;

    @MockBean
    private OrgLegFormRepository orgLegFormRepository;

    @Test
    void testFindAll() {
        OrgLegForm orgLegForm = new OrgLegForm();
        orgLegForm.setId(1L);
        orgLegForm.setNameFull("Общество с ограниченной ответственностью");
        orgLegForm.setNameShort("ООО");

        when(orgLegFormRepository.findAll()).thenReturn(Arrays.asList(orgLegForm));

        assertEquals(1, orgLegFormService.findAll().size());
        assertEquals("ООО", orgLegFormService.findAll().get(0).getNameShort());
    }

    @Test
    void testFindById() {
        OrgLegForm orgLegForm = new OrgLegForm();
        orgLegForm.setId(1L);
        orgLegForm.setNameFull("Общество с ограниченной ответственностью");
        orgLegForm.setNameShort("ООО");

        when(orgLegFormRepository.findById(1L)).thenReturn(Optional.of(orgLegForm));

        assertTrue(orgLegFormService.findById(1L).isPresent());
        assertEquals("ООО", orgLegFormService.findById(1L).get().getNameShort());
    }

    @Test
    void testSave() {
        OrgLegForm orgLegForm = new OrgLegForm();
        orgLegForm.setId(1L);
        orgLegForm.setNameFull("Общество с ограниченной ответственностью");
        orgLegForm.setNameShort("ООО");

        when(orgLegFormRepository.save(any(OrgLegForm.class))).thenReturn(orgLegForm);

        OrgLegForm savedOrgLegForm = orgLegFormService.save(orgLegForm);
        assertEquals("ООО", savedOrgLegForm.getNameShort());
    }

    @Test
    void testDeleteById() {
        orgLegFormService.deleteById(1L);
        verify(orgLegFormRepository, times(1)).deleteById(1L);
    }
}