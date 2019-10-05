package com.yazan98.books.server.service;

import com.yazan98.books.server.data.entities.Review;
import com.yazan98.books.server.data.repos.ReviewRepository;
import com.yazan98.books.server.exception.InvalidValueException;
import com.yazan98.books.server.exception.NotFoundException;
import com.yazan98.books.server.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/25/2019
 * Time : 3:23 AM
 */

@Service
@Transactional
public class ReviewService extends BaseService<Review, ReviewRepository> {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review save(Review review) throws InvalidValueException, NotFoundException {
        if (review.getAccountId() == null) {
            throw new InvalidValueException("Review Account Id Missing");
        } else if (review.getRating() == null) {
            throw new InvalidValueException("Review Rating Missing");
        } else if (review.getReview() == null) {
            throw new InvalidValueException("Review Review Missing");
        } else {
            getRepository().save(review);
            return getById(review.getId());
        }
    }

    @Override
    public ReviewRepository getRepository() {
        return reviewRepository;
    }
}
