package com.iralus.inventory.service;

import com.iralus.inventory.entity.Shipment;
import com.iralus.inventory.entity.ShipmentDetail;
import com.iralus.inventory.entity.ShipmentStatus;
import com.iralus.inventory.entity.ShipmentType;
import com.iralus.inventory.repository.FreightRateRepository;
import com.iralus.inventory.repository.RateRepository;
import com.iralus.inventory.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCostCalculationService implements IProductCostCalculationService {
    private RateRepository rateRepository;
    private ShipmentRepository shipmentRepository;
    private FreightRateRepository freightRateRepository;

    @Autowired
    public ProductCostCalculationService(RateRepository rateRepository, ShipmentRepository shipmentRepository, FreightRateRepository freightRateRepository) {
        this.rateRepository = rateRepository;
        this.shipmentRepository = shipmentRepository;
        this.freightRateRepository = freightRateRepository;
    }

    //final Double ALIBABA_COMMISSION = rateRepository.findByRateName("ALIBABA_COMMISSION").getRate();
    //final Double STAMP_DUTY = rateRepository.findByRateName("STAMP_DUTY").getRate();
    //final Double OTHER_DUTY = rateRepository.findByRateName("OTHER_DUTY").getRate();

    /*@Override
    public Double getCost(ShipmentDetail shipmentDetail) {
        return getCost(shipmentDetail.getUnitPrice(),shipmentDetail.getProduct().getVolume(), shipmentDetail.getShipment());
    }*/

    /*@Override
    public Double getCost(Double productPrice, Double volumeOrWeight, Integer shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId).get();
        return getCost(productPrice, volumeOrWeight, shipment);
    }*/

    /*@Override
    public Double getCost(Double productPrice, Double volumeOrWeight, Shipment shipment) {
        return getRateBasedCost(productPrice, shipment) +
                getTransportCostForProduct(shipment, volumeOrWeight) +
                getLogisticAndClearanceCostForProduct(shipment, volumeOrWeight);
    }*/

    /*protected Double getRateBasedCost(Double productPrice, Shipment shipment) {
        Double alibabaCharge = productPrice * (ALIBABA_COMMISSION / 100);
        Double stampDuty = productPrice * (STAMP_DUTY / 100);

        Double rateBasedCost = 0.0;
        if (OTHER_DUTY > 0) {
            Double otherCharge = productPrice * (OTHER_DUTY / 100);
            switch (shipment.getType()) {
                case SEA: {
                    Double SHIPPING_AGENT_COMMISSION = freightRateRepository.findByShippingAgentAndType(shipment.getShippingAgent(), ShipmentType.SEA).getCommission();
                    Double shippingAgentCharge = productPrice * (SHIPPING_AGENT_COMMISSION / 100);
                    rateBasedCost = alibabaCharge + shippingAgentCharge + stampDuty + otherCharge;
                }
                break;
                case AIR:
                    rateBasedCost = alibabaCharge + stampDuty + otherCharge;
                    break;
            }
        } else {
            rateBasedCost = alibabaCharge + stampDuty;
        }
        return rateBasedCost;
    }*/

    /*protected Double getTransportCostForProduct(Shipment shipment, Double volumeOrWeight) {
        Double exchangeRate = Math.max(shipment.getInitialExchangeRate(), shipment.getBalanceExchangeRate());
        Double chTransportCharge = shipment.getChTransportCharge();
        Double chTransportCost = 0.0;
        if (OTHER_DUTY > 0) {
            chTransportCost = (chTransportCharge + (chTransportCharge * ALIBABA_COMMISSION / 100)) +
                    ((chTransportCharge + (chTransportCharge * ALIBABA_COMMISSION / 100)) * STAMP_DUTY / 100) +
                    ((chTransportCharge + (chTransportCharge * ALIBABA_COMMISSION / 100)) * OTHER_DUTY / 100);
        } else {
            chTransportCost = (chTransportCharge + (chTransportCharge * ALIBABA_COMMISSION / 100)) +
                    ((chTransportCharge + (chTransportCharge * ALIBABA_COMMISSION / 100)) * STAMP_DUTY / 100);
        }
        Double slTransportCost = shipment.getSlTransportCharge();
        return ((chTransportCost * exchangeRate) + slTransportCost) / volumeOrWeight;
    }*/

    protected Double getLogisticAndClearanceCostForProduct(Shipment shipment, Double volumeOrWeight) {
        Double logisticAndClearance;
        if (shipment.getStatus().equals(ShipmentStatus.OPEN)) {
            logisticAndClearance = shipment.getFreightCharge();
        } else {
            switch (shipment.getType()) {
                case SEA:
                    logisticAndClearance = freightRateRepository.findByShippingAgentAndType(shipment.getShippingAgent(), ShipmentType.SEA).getRate();
                    break;
                case AIR:
                    logisticAndClearance = freightRateRepository.findByShippingAgentAndType(shipment.getShippingAgent(), ShipmentType.AIR).getRate();
                    break;
                default:
                    logisticAndClearance = 0.0;
                    break;
            }
        }

        double cbmOrKg;
        switch (shipment.getType()) {
            case SEA:
                cbmOrKg = 1000000.0;
                break;
            case AIR:
                cbmOrKg = 1000.0;
                break;
            default:
                cbmOrKg = 1.0;
                break;
        }
        return (logisticAndClearance / cbmOrKg) * volumeOrWeight;

    }
}
