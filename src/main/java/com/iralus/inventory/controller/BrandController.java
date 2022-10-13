package com.iralus.inventory.controller;

import com.iralus.inventory.dto.requestDto.BrandRequestDto;
import com.iralus.inventory.dto.responseDto.BrandResponseDto;
import com.iralus.inventory.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/brand")
@CrossOrigin(origins = "*")
public class BrandController {

    private BrandService brandService;


    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping(value="/add", consumes = "application/json")
    public ResponseEntity<BrandResponseDto> addBrand(@RequestBody BrandRequestDto brandRequestDto) {
        BrandResponseDto brandResponseDto = brandService.addBrand(brandRequestDto);
        return new ResponseEntity<>(brandResponseDto, HttpStatus.OK);
    }

    @GetMapping(value="/getAll")
    public ResponseEntity<List<BrandResponseDto>> getAuthors(){
        List<BrandResponseDto> brandResponseDto = brandService.getBrands();
        return new ResponseEntity<>(brandResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BrandResponseDto> getBrand(@PathVariable Integer id){
        BrandResponseDto brandResponseDto = brandService.getBrandById(id);
        return new ResponseEntity<>(brandResponseDto, HttpStatus.OK);
    }
}
