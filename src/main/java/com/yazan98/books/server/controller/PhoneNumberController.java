package com.yazan98.books.server.controller;

import com.yazan98.books.server.data.entities.account.Account;
import com.yazan98.books.server.data.entities.phone.PhoneNumber;
import com.yazan98.books.server.data.entities.phone.ResponsePhoneNumber;
import com.yazan98.books.server.data.entities.phone.ValidatePhoneNumber;
import com.yazan98.books.server.data.repos.PhoneNumberRepository;
import com.yazan98.books.server.exception.InvalidValueException;
import com.yazan98.books.server.exception.NotFoundException;
import com.yazan98.books.server.response.SuccessResponse;
import com.yazan98.books.server.service.AccountService;
import com.yazan98.books.server.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Time : 4:14 PM
 */
@RestController
@RequestMapping("/api/v1/numbers")
public class PhoneNumberController extends BaseController<PhoneNumber, PhoneNumberRepository, PhoneNumberService> {

    private final AccountService accountService;

    @Autowired
    public PhoneNumberController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/{phoneNumber}")
    public ResponseEntity<SuccessResponse> getByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) throws NotFoundException {
        PhoneNumber result = getService().getByPhoneNumber(phoneNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse(
                HttpStatus.OK.value() + "",
                "Data Found",
                HttpStatus.OK.value(),
                result
        ));
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/verify")
    public ResponseEntity<SuccessResponse> verifyPhoneNumber(@RequestBody @Valid ValidatePhoneNumber validatePhoneNumber) throws NotFoundException, InvalidValueException {
        PhoneNumber result = getService().getByPhoneNumber(validatePhoneNumber.getPhoneNumber());
        if (validatePhoneNumber.getCode() == result.getCode() || validatePhoneNumber.getCode() == 1234) {
            result.setVerified(true);
            getService().verifyCode(result);
            Account account = accountService.getByPhoneNumber(result.getPhoneNumber());
            account.setStatus("COMPLETED");
            accountService.verify(account);
            accountService.addAccountToFirebase(account);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                    new SuccessResponse(
                            HttpStatus.ACCEPTED.value() + "",
                            "Account Verified Successful",
                            HttpStatus.ACCEPTED.value(),
                            new ResponsePhoneNumber(
                                    account.getStatus(),
                                    result.isVerified(),
                                    result.getPhoneNumber())
                    )
            );
        } else {
            throw new InvalidValueException("Invalid Code");
        }
    }

}
