package com.bb.core.controller;

import com.bb.core.dto.Product;
import com.bb.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product")
    public ResponseEntity<List<Product>> get() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        return ResponseEntity.ok(productService.get(id));
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @DeleteMapping(value = "/product/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        productService.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping(value = "/product/{productId}/category/{categoryId}")
    public ResponseEntity<Product> addCategory(@PathVariable Long productId, @PathVariable Long categoryId) {
        return ResponseEntity.ok(productService.addCategory(productId, categoryId));
    }

}