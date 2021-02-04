package com.bb.core.service;

import com.bb.core.domain.ClientDomain;
import com.bb.core.domain.OrderDomain;
import com.bb.core.domain.ProductDomain;
import com.bb.core.dto.Order;
import com.bb.core.mapper.OrderMapper;
import com.bb.core.repository.ClientRepository;
import com.bb.core.repository.OrderRepository;
import com.bb.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository,
        ProductRepository productRepository,
        ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
    }

    public Order addProduct(Long orderId, Long productId){
        return orderRepository.findById(orderId)
            .map(orderDomain -> {
                ProductDomain productDomain = productRepository.findById(productId).orElseThrow(
                    () -> new RuntimeException("Element not found! For productId: " + productId));
                orderDomain.setProduct(productDomain);
                return orderRepository.save(orderDomain);
            }).map(OrderMapper::map)
            .orElseThrow(() -> new RuntimeException("Element not found! For orderId: " + orderId));
    }

    public Order get(Long id) {
        return orderRepository.findById(id)
            .map(OrderMapper::map)
            .orElseThrow(() -> new RuntimeException("Element not found! For orderId: " + id));
    }

    public List<Order> getAll() {
        return orderRepository.findAll()
            .stream()
            .map(OrderMapper::map)
            .collect(Collectors.toList());
    }

    public Set<Order> create(Long clientId) {
        ClientDomain clientDomain = clientRepository.findByClientId(clientId).orElseThrow(
            () -> new RuntimeException("Element not found! For clientId: " + clientId));
        clientDomain.setOrder(new OrderDomain());
        clientDomain = clientRepository.save(clientDomain);
        return clientDomain.getOrders().stream().map(OrderMapper::map).collect(Collectors.toSet());
    }
    public void delete(Long id) {
        ProductDomain product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Element not found! For orderId: " + id));
        productRepository.delete(product);
    }

}
