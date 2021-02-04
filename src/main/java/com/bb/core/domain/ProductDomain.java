package com.bb.core.domain;

import com.bb.core.constant.ProductType;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Data
@Table(name = "product")
public class ProductDomain {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    @OneToOne(fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    private ProductDetailsDomain productDetailsDomain;
    @ManyToMany
    @JoinTable(
        name = "product_category",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryDomain> categories;

    public void setCategory(CategoryDomain category) {
        if (this.categories == null){
            this.categories = Collections.emptySet();
        }
        this.categories.add(category);
    }
}
