package com.bb.core.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "rating")
public class RatingDomain {

    @OneToOne (fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    private ClientDomain client;
    @OneToOne (fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    private ProductDomain product;
    @Column(name = "mark")
    private Integer mark;

}
