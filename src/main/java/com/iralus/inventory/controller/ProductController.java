package com.iralus.inventory.controller;

import com.iralus.inventory.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return null;
    }
}
