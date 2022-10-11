package com.iralus.inventory.dto;

import com.iralus.inventory.dto.responseDto.BrandResponseDto;
import com.iralus.inventory.entity.Brand;

public class BrandMapper {

    public static BrandResponseDto brandToBrandResponseDto(Brand brand){
        BrandResponseDto brandResponseDto = new BrandResponseDto();
        brandResponseDto.setId(brand.getId());
        brandResponseDto.setName(brand.getName());
        brandResponseDto.setStatus(brand.getStatus().getStatusAsString());
        return brandResponseDto;
    }
}
