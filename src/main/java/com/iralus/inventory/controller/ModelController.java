package com.iralus.inventory.controller;

import com.iralus.inventory.entity.Model;
import com.iralus.inventory.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/model")
@CrossOrigin(origins = "*")
public class ModelController {
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Model model){
        return null;
    }
}
