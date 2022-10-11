package com.iralus.inventory.service;

import com.iralus.inventory.dto.requestDto.BrandRequestDto;
import com.iralus.inventory.dto.responseDto.BrandResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface BrandService {

    BrandResponseDto addBrand(BrandRequestDto brandRequestDto);
}
