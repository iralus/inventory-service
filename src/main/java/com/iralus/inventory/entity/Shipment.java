package com.iralus.inventory.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {
    @Id
    @SequenceGenerator(
            name = "shipment_sequence",
            sequenceName = "shipment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shipment_sequence"
    )
    private Integer id;
    private String code;
    @Enumerated(EnumType.STRING)
    private ShipmentType type;
    private Double volume;
    private Double weight;
    @Column(name = "order_placement_date")
    private Date orderPlacementDate;
    @Column(name = "preparation_date")
    private Date preparationDate;
    @Column(name = "loading_date")
    private Date loadingDate;
    @Column(name = "received_date")
    private Date receivedDate;
    @Column(name = "product_value")
    private Double productValue;
    @Column(name = "freight_charge")
    private Double freightCharge;
    @Column(name = "initial_payment")
    private Double initialPayment;
    @ManyToOne
    @JoinColumn(
            name = "initial_payment_method_id",
            referencedColumnName = "id"
    )
    private PaymentMethod initialPaymentMethod;
    @Column(name = "initial_exchange_rate")
    private Double initialExchangeRate;
    @Column(name = "balance_payment")
    private Double balancePayment;
    @ManyToOne
    @JoinColumn(
            name = "balance_payment_method_id",
            referencedColumnName = "id"
    )
    private PaymentMethod balancePaymentMethod;
    @Column(name = "balance_exchange_rate")
    private Double balanceExchangeRate;
    @Column(name = "ch_transport_charge")
    private Double chTransportCharge;
    @Column(name = "sl_transport_charge")
    private Double slTransportCharge;
    @Column(name = "alibaba_initial_charge")
    private Double alibabaInitialCharge;
    @Column(name = "alibaba_balance_charge")
    private Double alibabaBalanceCharge;
    @Column(name = "shipping_agent_commission")
    private Double shippingAgentCommission;
    @Column(name = "stamp_duty")
    private Double stampDuty;
    @Column(name = "other_charges")
    private Double otherCharges;
    @ManyToOne
    @JoinColumn(
            name = "supplier_id",
            referencedColumnName = "id"
    )
    private Stakeholder supplier;
    @ManyToOne
    @JoinColumn(
            name = "shipping_agent_id",
            referencedColumnName = "id"
    )
    private Stakeholder shippingAgent;
    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;
    @OneToMany(
            mappedBy="shipment",
            cascade = CascadeType.ALL
    )
    private Set<ShipmentDetail> shipmentDetails;
}
