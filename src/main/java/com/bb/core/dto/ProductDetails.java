package com.bb.core.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ProductDetails {

    private Long productDetailsId;
    private Integer quantity;
    private String description;
    private String serialNumber;
    private Double price;
    private Date dateInserted;

    public ProductDetails() {
        this.serialNumber = UUID.randomUUID().toString();
    }
}
