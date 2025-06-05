package com.example.clientinfosystem.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ogr_registration_id")
    private OrgRegistration ogrRegistration;

    @ManyToOne
    @JoinColumn(name = "org_leg_form_id")
    private OrgLegForm orgLegForm;

    @Column(nullable = false)
    private String nameFull;

    @Column(nullable = false)
    private String nameShort;

    @Column(nullable = false)
    private String numberReg;

    @Column(nullable = false)
    private LocalDate dataReg;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public OrgRegistration getOgrRegistration() { return ogrRegistration; }
    public void setOgrRegistration(OrgRegistration ogrRegistration) { this.ogrRegistration = ogrRegistration; }
    public OrgLegForm getOrgLegForm() { return orgLegForm; }
    public void setOrgLegForm(OrgLegForm orgLegForm) { this.orgLegForm = orgLegForm; }
    public String getNameFull() { return nameFull; }
    public void setNameFull(String nameFull) { this.nameFull = nameFull; }
    public String getNameShort() { return nameShort; }
    public void setNameShort(String nameShort) { this.nameShort = nameShort; }
    public String getNumberReg() { return numberReg; }
    public void setNumberReg(String numberReg) { this.numberReg = numberReg; }
    public LocalDate getDataReg() { return dataReg; }
    public void setDataReg(LocalDate dataReg) { this.dataReg = dataReg; }
}