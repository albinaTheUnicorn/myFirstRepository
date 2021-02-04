package com.bb.core.dto;

import com.bb.core.constant.OrderStatus;
import com.bb.core.domain.ProductDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class Order {

    private Long orderId;
    private String uniqueSerial;
    private Date date;
    private Double totalPrice;
    private Set<Product> products;
    private OrderStatus orderStatus;
}
