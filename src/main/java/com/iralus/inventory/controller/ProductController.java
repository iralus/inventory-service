package com.iralus.inventory.controller;

import com.iralus.inventory.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        return null;
    }
}
