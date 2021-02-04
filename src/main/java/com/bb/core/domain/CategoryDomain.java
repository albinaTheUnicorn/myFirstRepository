package com.bb.core.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "category")
public class CategoryDomain {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "description")
    private String description;
    @Column(name = "categoryName")
    private String categoryName;
}
