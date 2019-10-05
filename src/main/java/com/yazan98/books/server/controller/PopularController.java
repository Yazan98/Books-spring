package com.yazan98.books.server.controller;

import com.yazan98.books.server.data.entities.Popular;
import com.yazan98.books.server.data.repos.PopularRepository;
import com.yazan98.books.server.service.PopularService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/25/2019
 * Time : 2:28 AM
 */

@RestController
@RequestMapping("/api/v1/populars")
public class PopularController extends BaseController<Popular , PopularRepository , PopularService> {
}
