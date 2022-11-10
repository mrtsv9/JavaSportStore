package com.sport_store.web.controllers;

import com.sport_store.bll.services.abstractions.ProductTypeService;
import com.sport_store.dal.entities.ProductTypeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@RequestMapping("productType")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping
    public ResponseEntity<List<ProductTypeEntity>> getProducts() {
        try {
            var productTypes = productTypeService.getAll();
            var productTypes2 = new ArrayList<ProductTypeEntity>();
            for (ProductTypeEntity product : productTypes) {
                product.setProduct(null);
                productTypes2.add(product);
            }
            return ResponseEntity.ok(productTypes2);
        } catch (Exception e) {
            return internalServerError().build();
        }
    }

}
