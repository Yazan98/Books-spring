package com.yazan98.books.server.controller;

import com.yazan98.books.server.data.entities.account.Account;
import com.yazan98.books.server.data.entities.account.LoginBody;
import com.yazan98.books.server.data.repos.AccountRepository;
import com.yazan98.books.server.exception.InvalidValueException;
import com.yazan98.books.server.exception.NotFoundException;
import com.yazan98.books.server.response.BaseResponse;
import com.yazan98.books.server.response.SuccessResponse;
import com.yazan98.books.server.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 9:45 AM
 */

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController extends BaseController<Account, AccountRepository, AccountService> {

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<BaseResponse> login(@Valid @RequestBody LoginBody body) throws NotFoundException, InvalidValueException {
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse(
                        String.valueOf(HttpStatus.OK.value()),
                        "Data Found",
                        HttpStatus.OK.value(),
                        getService().login(body.getEmail(), body.getPassword())
                )
        );
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/{accountId}/reviews")
    public ResponseEntity<BaseResponse> getReviewsByAccountId(@PathVariable("accountId") Long accountId) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse(
                        HttpStatus.OK.value() + "",
                        "Data Found",
                        HttpStatus.OK.value(),
                        getService().getReviewsByAccountId(accountId)
                )
        );
    }

}
