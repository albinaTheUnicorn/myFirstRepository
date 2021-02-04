package com.bb.core.mapper;

import com.bb.core.domain.OrderDomain;
import com.bb.core.dto.Order;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;

public class OrderMapper {

    public static Order map(OrderDomain orderDomain) {
        Order order = new Order();
        order.setOrderId(orderDomain.getOrderId());
        order.setUniqueSerial(orderDomain.getUniqueSerial());
        order.setDate(orderDomain.getDate());
        order.setTotalPrice(orderDomain.getTotalPrice());
        if (!CollectionUtils.isEmpty(orderDomain.getProducts())) {
            order.setProducts(orderDomain.getProducts()
                .stream()
                .map(ProductMapper::map)
                .collect(Collectors.toSet()));
        }
        return order;

    }

    public static OrderDomain map(Order order) {
        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setOrderId(order.getOrderId());
        orderDomain.setUniqueSerial(order.getUniqueSerial());
        orderDomain.setDate(order.getDate());
        orderDomain.setTotalPrice(order.getTotalPrice());
        return orderDomain;
    }

}
