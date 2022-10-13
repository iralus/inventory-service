package com.iralus.inventory.dto;

import com.iralus.inventory.dto.responseDto.BrandResponseDto;
import com.iralus.inventory.entity.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandMapper {

    public static BrandResponseDto brandToBrandResponseDto(Brand brand){
        BrandResponseDto brandResponseDto = new BrandResponseDto();
        brandResponseDto.setId(brand.getId());
        brandResponseDto.setName(brand.getName());
        brandResponseDto.setStatus(brand.getStatus().getStatusAsString());
        return brandResponseDto;
    }

    public static List<BrandResponseDto> brandToBrandResponseDto(List<Brand> brands){
        List<BrandResponseDto> brandResponseDtoList = new ArrayList<>();
        for (Brand brand : brands) {
            brandResponseDtoList.add(brandToBrandResponseDto(brand));
        }
        return brandResponseDtoList;
    }
}
