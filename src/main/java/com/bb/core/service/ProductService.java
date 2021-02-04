package com.bb.core.service;

import com.bb.core.domain.CategoryDomain;
import com.bb.core.domain.ProductDomain;
import com.bb.core.dto.Product;
import com.bb.core.mapper.ProductMapper;
import com.bb.core.repository.CategoryRepository;
import com.bb.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(CategoryRepository categoryRepository,
        ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public Product addCategory(Long productId, Long categoryId){
        return productRepository.findById(productId)
            .map(productDomain -> {
                CategoryDomain categoryDomain = categoryRepository.findById(categoryId)
                    .orElseThrow(
                        () -> new RuntimeException("Element not found! For productId: " + productId));
                productDomain.setCategory(categoryDomain);
                return productRepository.save(productDomain);
            })
            .map(ProductMapper::map)
            .orElseThrow(() -> new RuntimeException("Element not found! For productId: " + productId));
    }

    public Product get(Long id) {
        return productRepository.findById(id)
            .map(ProductMapper::map)
            .orElseThrow(() -> new RuntimeException("Element not found! For productId: " + id));
    }
    public List<Product> getAll() {
        return productRepository.findAll()
            .stream()
            .map(ProductMapper::map)
            .collect(Collectors.toList());
    }
    public Product save(Product product) {
        return ProductMapper.map(productRepository.save(ProductMapper.map(product)));
    }
    public void delete(Long id) {
        ProductDomain product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Element not found! For productId: " + id));
        productRepository.delete(product);
    }

}
