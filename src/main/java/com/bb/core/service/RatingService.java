package com.bb.core.service;

import com.bb.core.domain.RatingDomain;
import com.bb.core.dto.Rating;
import com.bb.core.mapper.RatingMapper;
import com.bb.core.repository.RatingRepository;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;


    public RatingService(RatingRepository ratingRepository,
        RatingMapper ratingMapper) {
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }

    public Double getAvgMarkByProductId(Long productId) {
        return ratingRepository.findByProductProductId(productId).stream()
            .map(RatingDomain::getMark).mapToLong(a -> a).average().orElse(0d);
    }

    public Rating save(Rating rating) {
        return ratingMapper.map(
            ratingRepository.save(
                ratingMapper.map(rating)));
    }
}
