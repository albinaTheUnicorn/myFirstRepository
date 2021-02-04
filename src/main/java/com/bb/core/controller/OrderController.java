package com.bb.core.controller;

import com.bb.core.dto.Order;
import com.bb.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order")
    public ResponseEntity<List<Order>> get(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping(value = "/order/{id}")
    public ResponseEntity<Order> get(@PathVariable Long id){
        return ResponseEntity.ok(orderService.get(id));
    }

    @PostMapping(value = "/order/{clientId}")
    public ResponseEntity<Set<Order>> add(@PathVariable Long clientId){
        return ResponseEntity.ok(orderService.create(clientId));
    }
    @PostMapping(value = "/order/{orderId}/product/{productId}")
    public ResponseEntity<Order> add(@PathVariable Long orderId, @PathVariable Long productId){
        return ResponseEntity.ok(orderService.addProduct(orderId, productId));
    }

    @DeleteMapping(value = "/order/{id}")
    public HttpStatus delete(@PathVariable Long id){
        orderService.delete(id);
        return HttpStatus.OK;
    }
}
