package com.bb.core.esDocument;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName = "product_rating", replicas = 0, refreshInterval = "-1")
@Data
public class ProductRatingDoc {

    @Id
    private Long id;
    private Integer avgRating;
    private Long productId;
    private String searchStr;

    public ProductRatingDoc(Integer avgRating, Long productId) {
        this.avgRating = avgRating;
        this.productId = productId;
        this.searchStr = String.valueOf(avgRating + productId);
    }
}
