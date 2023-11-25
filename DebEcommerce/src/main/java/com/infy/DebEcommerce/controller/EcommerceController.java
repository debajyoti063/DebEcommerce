package com.infy.DebEcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.DebEcommerce.data.CategoryCreationRequest;
import com.infy.DebEcommerce.data.ProductCreationRequest;
import com.infy.DebEcommerce.exception.ResourceNotFoundException;
import com.infy.DebEcommerce.model.Category;
import com.infy.DebEcommerce.model.Product;
import com.infy.DebEcommerce.service.EcommerceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/ecommerce")
@RequiredArgsConstructor
public class EcommerceController {
	
    private final EcommerceService ecommerceService;   
    
    @PostMapping("/category")
    public ResponseEntity<Category> createCategory (@RequestBody CategoryCreationRequest request) {
        return ResponseEntity.ok(ecommerceService.createCategory(request));
    }
    
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getCategory () throws ResourceNotFoundException {
        return ResponseEntity.ok(ecommerceService.getCategories());
    }
    
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Category> getCategoryById (@PathVariable String categoryId) throws ResourceNotFoundException {
        return ResponseEntity.ok(ecommerceService.getCategoryById(categoryId));
    }
    
    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProductById (@PathVariable String productId) throws ResourceNotFoundException {
        return ResponseEntity.ok(ecommerceService.getProductById(productId));
    }
    
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct (@RequestBody ProductCreationRequest request) throws ResourceNotFoundException {
        return ResponseEntity.ok(ecommerceService.createProduct(request));
    }
    
    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<Void> deleteCategory (@PathVariable String categoryId) {
    	ecommerceService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProduct (@PathVariable String productId) {
    	ecommerceService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) String categoryId) throws ResourceNotFoundException {
            if (categoryId == null) {
                return ResponseEntity.ok(ecommerceService.getProducts());
            }
            return ResponseEntity.ok(ecommerceService.getProductsByCatId(categoryId));
        }
}