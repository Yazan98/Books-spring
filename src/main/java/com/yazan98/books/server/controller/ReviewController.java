package com.yazan98.books.server.controller;

import com.yazan98.books.server.data.entities.Review;
import com.yazan98.books.server.data.repos.ReviewRepository;
import com.yazan98.books.server.service.ReviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/25/2019
 * Time : 3:25 AM
 */

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController extends BaseController<Review , ReviewRepository , ReviewService> {

}
