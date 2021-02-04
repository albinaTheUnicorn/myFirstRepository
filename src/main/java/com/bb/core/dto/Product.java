package com.bb.core.dto;

import com.bb.core.constant.ProductType;
import com.bb.core.domain.CategoryDomain;
import lombok.Data;

import java.util.Set;

@Data
public class Product {
    private Long productId;
    private String productName;
    private String brandName;
    private ProductDetails productDetails;
    private Set<Category> categories;
    private ProductType productType;

}
