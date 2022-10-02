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
public class Model {
    @Id
    @SequenceGenerator(
            name = "model_sequence",
            sequenceName = "model_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "model_sequence"
    )
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(
            name = "brand_id",
            referencedColumnName = "id"
    )
    private Brand brand;
    @Enumerated(EnumType.STRING)
    private Status status;
}
