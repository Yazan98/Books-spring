package com.yazan98.books.server.controller;

import com.yazan98.books.server.data.entities.book.Book;
import com.yazan98.books.server.data.repos.BookRepository;
import com.yazan98.books.server.exception.NotFoundException;
import com.yazan98.books.server.response.BaseResponse;
import com.yazan98.books.server.response.SuccessResponse;
import com.yazan98.books.server.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/25/2019
 * Time : 2:41 AM
 */

@RestController
@RequestMapping("/api/v1/books")
public class BookController extends BaseController<Book, BookRepository, BookService> {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/{bookId}/reviews")
    public ResponseEntity<BaseResponse> getReviewsByBookId(@PathVariable("bookId") Long bookId) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse(
                        HttpStatus.OK.value() + "",
                        "Data Found",
                        HttpStatus.OK.value(),
                        getService().getReviewsByBookId(bookId)
                )
        );
    }
}
