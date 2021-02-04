package com.bb.core.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "client")
public class ClientDomain {
    @Id
    @GeneratedValue
    @Column(name = "client_id")
    private Long clientId;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "client_order",
        joinColumns = { @JoinColumn(name = "client_id") },
        inverseJoinColumns = { @JoinColumn(name = "order_id") }
    )
    Set<OrderDomain> orders = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    private PersonalDataDomain personalDataDomain;

    public void setOrder(OrderDomain orderDomain) {
        if (this.orders == null){
            this.orders = Collections.emptySet();
        }
        this.orders.add(orderDomain);
    }
}
