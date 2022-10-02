package com.iralus.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stakeholder {
    @Id
    @SequenceGenerator(
            name = "stakeholder_sequence",
            sequenceName = "stakeholder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stakeholder_sequence"
    )
    private Integer id;
    @Column(name = "company_name")
    private String companyName;
    @Enumerated(EnumType.STRING)
    private StakeholderType type;
    @Column(name = "short_code")
    private String shortCode;
    private String address;
    @Column(name = "contact_no")
    private String contactNo;
    private String email;
    @Column(name = "alibaba_profile")
    private String alibabaProfile;
    private String website;
    @Enumerated(EnumType.STRING)
    private Status status;
}
