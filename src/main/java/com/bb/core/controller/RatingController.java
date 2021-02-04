package com.bb.core.controller;

import com.bb.core.service.RatingService;

public class RatingController {
private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }
}
