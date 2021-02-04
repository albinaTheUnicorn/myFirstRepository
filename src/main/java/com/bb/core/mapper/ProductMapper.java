package com.bb.core.mapper;

import com.bb.core.domain.ProductDomain;
import com.bb.core.dto.Product;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;

public class ProductMapper {

    public static Product map(ProductDomain productDomain) {
        Product product = new Product();
        product.setProductId(productDomain.getProductId());
        product.setProductName(productDomain.getProductName());
        product.setProductDetails(ProductDetailsMapper.map(productDomain.getProductDetailsDomain()));
        if (!CollectionUtils.isEmpty(productDomain.getCategories())) {
            product.setCategories(productDomain.getCategories()
                .stream()
                .map(CategoryMapper::map)
                .collect(Collectors.toSet()));
        }
        return product;
    }

    public static ProductDomain map(Product product) {
        ProductDomain productDomain = new ProductDomain();
        productDomain.setProductId(product.getProductId());
        productDomain.setProductName(product.getProductName());
        productDomain.setProductDetailsDomain(ProductDetailsMapper.map(product.getProductDetails()));
        return productDomain;
    }

}

