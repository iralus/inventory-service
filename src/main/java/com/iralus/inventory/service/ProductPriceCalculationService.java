package com.iralus.inventory.service;

import com.iralus.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPriceCalculationService implements IProductPriceCalculationService{

    private ProductRepository productRepository;

    @Autowired
    public ProductPriceCalculationService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Double getWholesalePrice(Double productCost, Integer productId) {
        return productCost +
                productCost*(productRepository.findById(productId).get().getWholesaleProfitMarkup()/100);
    }

    @Override
    public Double getRetailPrice(Double productCost, Integer productId) {
        return productCost +
                productCost*(productRepository.findById(productId).get().getRetailProfitMarkup()/100);
    }

    @Override
    public Double getSalePrice(Double productCost, Integer productId) {
        Double retailPrice = getRetailPrice(productCost, productId);
        return retailPrice - retailPrice*(productRepository.findById(productId).get().getSalePercentage()/100);
    }

    @Override
    public Double getWarrantyPrice(Double productCost, Integer productId) {
        return productCost +
                productCost*(productRepository.findById(productId).get().getWarrantyProfitMarkup()/100);
    }

    @Override
    public Double getMinimumPrice(Double productCost, Integer productId) {
        return productCost +
                productCost*(productRepository.findById(productId).get().getMinimumProfitMarkup()/100);
    }
}
