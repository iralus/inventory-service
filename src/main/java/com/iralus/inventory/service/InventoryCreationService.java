package com.iralus.inventory.service;

import com.iralus.inventory.entity.Inventory;
import com.iralus.inventory.entity.InventoryStatus;
import com.iralus.inventory.entity.Shipment;
import com.iralus.inventory.entity.ShipmentDetail;
import com.iralus.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InventoryCreationService implements IInventoryCreationService{

    private IProductCostCalculationService productCostCalculationService;
    private IProductPriceCalculationService productPriceCalculationService;
    private InventoryRepository inventoryRepository;

    @Autowired
    public InventoryCreationService(IProductCostCalculationService productCostCalculationService, IProductPriceCalculationService productPriceCalculationService, InventoryRepository inventoryRepository) {
        this.productCostCalculationService = productCostCalculationService;
        this.productPriceCalculationService = productPriceCalculationService;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<Inventory> addInventory(Shipment shipment) {
        /*Set<ShipmentDetail> shipmentDetails = shipment.getShipmentDetails();
        List<Inventory> inventories = new ArrayList<>();
        for (ShipmentDetail shipmentDetail : shipmentDetails) {
            Double productCost = productCostCalculationService.getCost(shipmentDetail);
            Integer productId = shipmentDetail.getProduct().getId();
            Inventory inventory =
                    Inventory.builder()
                            .product(shipmentDetail.getProduct())
                            .shipment(shipment)
                            .quantity(shipmentDetail.getQuantity())
                            .productCost(productCost)
                            .wholesalePrice(productPriceCalculationService.getWholesalePrice(productCost, productId))
                            .retailPrice(productPriceCalculationService.getRetailPrice(productCost, productId))
                            .salePrice(productPriceCalculationService.getSalePrice(productCost, productId))
                            .warrantyPrice(productPriceCalculationService.getWarrantyPrice(productCost, productId))
                            .minimumPrice(productPriceCalculationService.getMinimumPrice(productCost, productId))
                            .status(InventoryStatus.OPEN)
                            .build();
            inventories.add(inventory);
        }
        return inventoryRepository.saveAll(inventories);*/
        return null;
    }
}
