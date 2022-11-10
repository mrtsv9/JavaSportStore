package com.sport_store.web.controllers;

import com.sport_store.bll.models.product_service.GetProduct;
import com.sport_store.bll.models.product_service.PostProduct;
import com.sport_store.bll.models.product_service.PutProduct;
import com.sport_store.bll.models.user_service.GetUser;
import com.sport_store.bll.services.abstractions.ProductService;
import com.sport_store.bll.services.abstractions.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.internalServerError;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<GetUser>> getProducts() {
        try {
            var products = userService.getAll();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return internalServerError().build();
        }
    }

//    @PostMapping
//    public ResponseEntity postProduct (@RequestBody PostProduct postProduct) {
//        try {
//            userService.createProduct(postProduct);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        } catch (Exception e) {
//            return ResponseEntity.status(500).build();
//        }
//    }
//
//    @PutMapping
//    public ResponseEntity putProduct(@RequestBody PutProduct putProduct) {
//        try {
//            userService.updateProduct(putProduct);
//            return ResponseEntity.ok().body("Все ок!");
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Bad request! " + e.getMessage());
//        }
//    }
//
//    @DeleteMapping
//    public ResponseEntity deleteProduct(@RequestParam int id) {
//        try {
//            userService.deleteBook(id);
//            return ResponseEntity.ok().body("Все ок!");
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Bad request! " + e.getMessage());
//        }
//    }
}