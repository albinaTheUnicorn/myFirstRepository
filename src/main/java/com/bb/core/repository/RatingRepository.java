package com.bb.core.repository;

import com.bb.core.domain.RatingDomain;
import com.bb.core.dto.Rating;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingRepository extends CrudRepository<RatingDomain, Long> {
    List<RatingDomain> findByProductProductId(Long productId);
}
