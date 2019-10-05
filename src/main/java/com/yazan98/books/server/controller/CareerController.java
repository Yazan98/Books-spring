package com.yazan98.books.server.controller;

import com.yazan98.books.server.data.entities.career.Career;
import com.yazan98.books.server.data.repos.CareerRepository;
import com.yazan98.books.server.service.CareerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/26/2019
 * Time : 10:45 PM
 */

@RestController
@RequestMapping("/api/v1/careers")
public class CareerController extends BaseController<Career , CareerRepository , CareerService> {

}
