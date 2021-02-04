package com.bb.core.controller;

import com.bb.core.dto.Category;
import com.bb.core.dto.Product;
import com.bb.core.service.CategoryService;
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
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/category")
    public ResponseEntity<List<Category>> get() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping(value = "/category/{id}")
    public ResponseEntity<Category> get(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.get(id));
    }

    @PostMapping(value = "/category")
    public ResponseEntity<Category> add(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.save(category));
    }

    @DeleteMapping(value = "/category/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        categoryService.delete(id);
        return HttpStatus.OK;
    }
}