package com.yazan98.books.server.controller;

import com.yazan98.books.server.data.entities.aother.Author;
import com.yazan98.books.server.data.repos.AuthorRepository;
import com.yazan98.books.server.service.AuthorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 4:59 PM
 */

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController extends BaseController<Author, AuthorRepository, AuthorService> {

}
