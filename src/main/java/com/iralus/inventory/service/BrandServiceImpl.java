package com.iralus.inventory.service;

import com.iralus.inventory.dto.BrandMapper;
import com.iralus.inventory.dto.requestDto.BrandRequestDto;
import com.iralus.inventory.dto.responseDto.BrandResponseDto;
import com.iralus.inventory.entity.Brand;
import com.iralus.inventory.entity.Status;
import com.iralus.inventory.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService{

    private BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandResponseDto addBrand(BrandRequestDto brandRequestDto) {
        Brand brand = new Brand();
        brand.setName(brandRequestDto.getName());
        brand.setStatus(Status.valueOf(brandRequestDto.getStatus()));
        brandRepository.save(brand);
        return BrandMapper.brandToBrandResponseDto(brand);
    }
}
