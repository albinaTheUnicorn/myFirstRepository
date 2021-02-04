package com.bb.core.esRepository;

import com.bb.core.esDocument.ProductRatingDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ESDocRepository extends ElasticsearchRepository<ProductRatingDoc, Long> {

}
