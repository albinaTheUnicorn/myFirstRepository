package com.bb.core.mapper;

import com.bb.core.domain.ProductDetailsDomain;
import com.bb.core.dto.ProductDetails;

import java.util.Date;

public class ProductDetailsMapper {

    public static ProductDetails map(ProductDetailsDomain productDetailsDomain){
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductDetailsId(productDetailsDomain.getProductDetailId());
        productDetails.setQuantity(productDetailsDomain.getQuantity());
        productDetails.setDescription(productDetailsDomain.getDescription());
        productDetails.setSerialNumber(productDetailsDomain.getSerialNumber());
        productDetails.setPrice(productDetailsDomain.getPrice());
        productDetails.setDateInserted(productDetailsDomain.getDateInserted());
        return productDetails;
    }
    public static ProductDetailsDomain map(ProductDetails productDetails){
        ProductDetailsDomain productDetailsDomain = new ProductDetailsDomain();
        productDetailsDomain.setProductDetailId(productDetails.getProductDetailsId());
        productDetailsDomain.setQuantity(productDetails.getQuantity());
        productDetailsDomain.setDescription(productDetails.getDescription());
        productDetailsDomain.setSerialNumber(productDetails.getSerialNumber());
        productDetailsDomain.setPrice(productDetails.getPrice());
        productDetailsDomain.setDateInserted(productDetails.getDateInserted() != null ? productDetails.getDateInserted() : new Date());
        return productDetailsDomain;
    }


}
