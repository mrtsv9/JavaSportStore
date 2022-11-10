package com.sport_store.web.controllers;

import com.sport_store.bll.models.product_service.GetProduct;
import com.sport_store.bll.models.product_service.PostProduct;
import com.sport_store.bll.models.product_service.PutProduct;
import com.sport_store.bll.services.abstractions.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<GetProduct>> getProducts() {
        try {
            var products = productService.getAll();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity postProduct (@RequestBody PostProduct postProduct) {
        try {
            productService.createProduct(postProduct);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping
    public ResponseEntity putProduct(@RequestBody PutProduct putProduct) {
        try {
            productService.updateProduct(putProduct);
            return ResponseEntity.ok().body("Все ок!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request! " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteProduct(@RequestParam int id) {
        try {
            productService.deleteBook(id);
            return ResponseEntity.ok().body("Все ок!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request! " + e.getMessage());
        }
    }
}