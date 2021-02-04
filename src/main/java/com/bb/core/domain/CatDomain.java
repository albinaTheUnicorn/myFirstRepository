package com.bb.core.domain;

import com.bb.core.dto.Cat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cats")
public class CatDomain {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double weight;

    public CatDomain() {
    }

    public CatDomain(Cat cat) {
        this.name = cat.getName();
        this.weight = cat.getWeight();
    }
}
