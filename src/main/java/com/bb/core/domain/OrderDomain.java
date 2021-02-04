package com.bb.core.domain;

import com.bb.core.constant.OrderStatus;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "orders")
public class OrderDomain {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "unique_serial")
    private String uniqueSerial;
    @Column(name = "date")
    private Date date;
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Column(name = "total_price")
    private Double totalPrice;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "order_product",
        joinColumns = { @JoinColumn(name = "order_id") },
        inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    private Set<ProductDomain> products;

    public void setProduct(ProductDomain product) {
        if (this.products == null) {
            this.products = Collections.emptySet();
        }
        this.products.add(product);
        this.totalPrice = products.stream()
            .map(productDomain -> productDomain.getProductDetailsDomain().getPrice())
            .reduce((accum, param) -> accum + param)
            .orElseThrow(() -> new IllegalArgumentException("Can not count total price"));

    }

    public OrderDomain() {
        this.uniqueSerial = UUID.randomUUID().toString();
        this.date = new Date();
    }
}
