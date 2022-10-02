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
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Integer id;
    private String name;
    @Column(name = "tag_name")
    private String tagName;
    private String oem;
    @Column(name = "hs_code")
    private String hsCode;
    private Double volume;
    private Double weight;
    @ManyToOne
    @JoinColumn(
            name = "brand_id",
            referencedColumnName = "id"
    )
    private Brand brand;
    @ManyToOne
    @JoinColumn(
            name = "model_id",
            referencedColumnName = "id"
    )
    private Model model;
    @Column(name = "wholesale_profit_markup")
    private Integer wholesaleProfitMarkup;
    @Column(name = "retail_profit_markup")
    private Integer retailProfitMarkup;
    @Column(name = "sale_percentage")
    private Integer salePercentage;
    @Column(name = "warranty_profit_markup")
    private Integer warrantyProfitMarkup;
    @Column(name = "minimum_profit_markup")
    private Integer minimumProfitMarkup;
    @Enumerated(EnumType.STRING)
    private Status status;
}
