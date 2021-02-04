package com.bb.core.mapper;

import com.bb.core.domain.CategoryDomain;
import com.bb.core.dto.Category;

public class CategoryMapper {

    public static Category map(CategoryDomain categoryDomain){
        Category category = new Category();
        category.setCategoryId(categoryDomain.getCategoryId());
        category.setCategoryName(categoryDomain.getCategoryName());
        category.setDescription(categoryDomain.getDescription());
        return category;
    }
    public static CategoryDomain map(Category category){
        CategoryDomain categoryDomain = new CategoryDomain();
        categoryDomain.setCategoryId(category.getCategoryId());
        categoryDomain.setCategoryName(category.getCategoryName());
        categoryDomain.setDescription(category.getDescription());

        return categoryDomain;
    }

}
