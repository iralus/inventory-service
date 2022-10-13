package com.iralus.inventory.service;

import com.iralus.inventory.dto.requestDto.BrandRequestDto;
import com.iralus.inventory.dto.responseDto.BrandResponseDto;
import com.iralus.inventory.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {

    BrandResponseDto addBrand(BrandRequestDto brandRequestDto);
    List<BrandResponseDto> getBrands();
    BrandResponseDto getBrandById(Integer id);
    Brand getBrand(Integer id);

}
