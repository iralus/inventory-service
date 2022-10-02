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
public class Inventory {
    @Id
    @SequenceGenerator(
            name = "inventory_sequence",
            sequenceName = "inventory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inventory_sequence"
    )
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id"
    )
    private Product product;
    @ManyToOne
    @JoinColumn(
            name = "shipment_id",
            referencedColumnName = "id"
    )
    private Shipment shipment;
    private Integer quantity;
    @Column(name = "product_cost")
    private Double productCost;
    @Column(name = "wholesale_price")
    private Double wholesalePrice;
    @Column(name = "retail_price")
    private Double retailPrice;
    @Column(name = "sale_price")
    private Double salePrice;
    @Column(name = "warranty_price")
    private Double warrantyPrice;
    @Column(name = "minimum_price")
    private Double minimumPrice;
    @Enumerated(EnumType.STRING)
    private InventoryStatus status;
}
