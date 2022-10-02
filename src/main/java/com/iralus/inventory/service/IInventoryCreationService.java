package com.iralus.inventory.service;

import com.iralus.inventory.entity.Inventory;
import com.iralus.inventory.entity.Shipment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IInventoryCreationService {
    List<Inventory> addInventory(Shipment shipment);
}
