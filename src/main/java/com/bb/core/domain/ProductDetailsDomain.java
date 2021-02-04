package com.bb.core.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "product_details")
public class ProductDetailsDomain {
    @Id
    @GeneratedValue
    @Column(name = "product_detail_id")
    private Long productDetailId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "description")
    private String description;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "price")
    private Double price;
    @Column(name = "date_inserted")
    private Date dateInserted;

}
