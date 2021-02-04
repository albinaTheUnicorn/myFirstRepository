package com.bb.core.mapper;

import com.bb.core.domain.ClientDomain;
import com.bb.core.domain.ProductDomain;
import com.bb.core.domain.RatingDomain;
import com.bb.core.dto.Rating;
import com.bb.core.repository.ClientRepository;
import com.bb.core.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {

    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    @Autowired
    public RatingMapper(ClientRepository clientRepository,
        ProductRepository productRepository) {
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    public Rating map(RatingDomain ratingDomain) {
        Rating rating = new Rating();

        rating.setMark(ratingDomain.getMark());
        rating.setProductId(ratingDomain.getProduct().getProductId());
        rating.setClientId(ratingDomain.getClient().getClientId());
        return rating;
    }

    public RatingDomain map(Rating rating) {
        final ClientDomain client = clientRepository.findByClientId(rating.getClientId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No client found for provided id: " + rating.getClientId()));

        final ProductDomain productDomain = productRepository.findByProductId(rating.getProductId())
            .orElseThrow(() -> new IllegalArgumentException(
                "No product found for provided id: " + rating.getProductId()));

        return RatingDomain
            .builder()
            .client(client)
            .product(productDomain)
            .mark(rating.getMark())
            .build();
    }

}
