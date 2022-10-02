package com.iralus.inventory.service;

import com.iralus.inventory.entity.Shipment;
import com.iralus.inventory.entity.ShipmentDetail;
import org.springframework.stereotype.Service;

@Service
public interface IProductCostCalculationService {
    Double getCost(ShipmentDetail shipmentDetail);
    Double getCost(Double productPrice, Double volumeOrWeight, Integer shipmentId);
    Double getCost(Double productPrice, Double volumeOrWeight, Shipment shipment);

}
