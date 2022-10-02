package com.iralus.inventory.service;

import org.springframework.stereotype.Service;

@Service
public interface IProductPriceCalculationService {
    Double getWholesalePrice(Double productCost, Integer productId);
    Double getRetailPrice(Double productCost, Integer productId);
    Double getSalePrice(Double productCost, Integer productId);
    Double getWarrantyPrice(Double productCost, Integer productId);
    Double getMinimumPrice(Double productCost, Integer productId);

}
