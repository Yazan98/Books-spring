package com.yazan98.books.server.controller;

import com.yazan98.books.server.data.entities.Place;
import com.yazan98.books.server.data.repos.PlaceRepository;
import com.yazan98.books.server.service.PlaceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 4:46 PM
 */

@RestController
@RequestMapping("/api/v1/places")
public class PlaceController extends BaseController<Place , PlaceRepository , PlaceService> {

}
