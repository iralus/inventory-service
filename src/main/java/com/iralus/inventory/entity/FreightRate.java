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
public class FreightRate {
    @Id
    @SequenceGenerator(
            name = "freight_rate_sequence",
            sequenceName = "freight_rate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "freight_rate_sequence"
    )
    private Integer id;
    @ManyToOne
    @JoinColumn(
            name = "shipping_agent_id",
            referencedColumnName = "id"
    )
    private Stakeholder shippingAgent;
    @Enumerated(EnumType.STRING)
    private ShipmentType type;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    private Double rate;
    private Double commission;
    @Enumerated(EnumType.ORDINAL)
    private Status status;

}
