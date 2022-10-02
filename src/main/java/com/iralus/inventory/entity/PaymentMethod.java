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
public class PaymentMethod {
    @Id
    @SequenceGenerator(
            name = "payment_method_sequence",
            sequenceName = "payment_method_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_method_sequence"
    )
    private Integer id;
    @Column(name = "payment_method_name")
    private String paymentMethodName;
    @Enumerated(EnumType.STRING)
    private Status status;
}
