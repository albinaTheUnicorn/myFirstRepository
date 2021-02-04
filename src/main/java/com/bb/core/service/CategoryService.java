package com.bb.core.service;

import com.bb.core.domain.CategoryDomain;
import com.bb.core.dto.Category;
import com.bb.core.mapper.CategoryMapper;
import com.bb.core.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category get(Long id) {
        return categoryRepository.findById(id)
            .map(CategoryMapper::map)
            .orElseThrow(() -> new RuntimeException("Element not found! For categoryId: " + id));
    }
    public List<Category> getAll() {
        return categoryRepository.findAll()
            .stream()
            .map(CategoryMapper::map)
            .collect(Collectors.toList());
    }
    public Category save(Category category) {
        return CategoryMapper.map(categoryRepository.save(CategoryMapper.map(category)));
    }
    public void delete(Long id) {
        CategoryDomain category = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Element not found! For categoryId: " + id));
        categoryRepository.delete(category);
    }

}
