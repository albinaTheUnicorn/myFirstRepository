package com.bb.core.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "address")
public class AddressDomain {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "city")
    private String city;
    @Column(name = "post_carrier")
    private String postCarrier;
    @Column(name = "post_carrier_department_number")
    private String postCarrierDepartmentNumber;
}
