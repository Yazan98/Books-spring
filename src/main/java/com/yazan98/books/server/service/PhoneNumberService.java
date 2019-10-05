package com.yazan98.books.server.service;

import com.yazan98.books.server.data.entities.phone.PhoneNumber;
import com.yazan98.books.server.data.repos.PhoneNumberRepository;
import com.yazan98.books.server.exception.InvalidValueException;
import com.yazan98.books.server.exception.NotFoundException;
import com.yazan98.books.server.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 4:07 PM
 */
@Service
@Transactional
public class PhoneNumberService extends BaseService<PhoneNumber, PhoneNumberRepository> {

    private Random rand;
    private final PhoneNumberRepository repository;

    @Autowired
    public PhoneNumberService(PhoneNumberRepository repository) {
        this.repository = repository;
    }

    @Override
    public PhoneNumber save(PhoneNumber phoneNumber) throws InvalidValueException, NotFoundException {
        if (phoneNumber.getCode() == 0) {
            throw new InvalidValueException("Code Required");
        } else if (phoneNumber.getPhoneNumber().isEmpty()) {
            throw new InvalidValueException("Phone Number Required");
        } else {
            try {
                getByPhoneNumber(phoneNumber.getPhoneNumber());
                throw new InvalidValueException("Phone Number Already Registered");
            } catch (NotFoundException ex) {
                getRepository().save(phoneNumber);
                return getById(phoneNumber.getId());
            }
        }
    }

    public void verifyCode(PhoneNumber phoneNumber){
        getRepository().save(phoneNumber);
    }

    public PhoneNumber registerPhoneNumber(String phoneNumber , Long id) throws NotFoundException {
        getRepository().save(new PhoneNumber(phoneNumber, generateCode() , id));
        return getByPhoneNumber(phoneNumber);
    }

    public PhoneNumber getByPhoneNumber(String phoneNumber) throws NotFoundException {
        if (getRepositoryStatus(getRepository())) {
            try {
                return getRepository().findByPhoneNumber(phoneNumber);
            } catch (NoSuchElementException ex) {
                throw new NotFoundException(ex.getMessage());
            }
        } else {
            throw new NotFoundException("Data Not Found");
        }
    }

    public int generateCode() {
        rand = new Random();
        return rand.nextInt(10000);
    }

    @Override
    public PhoneNumberRepository getRepository() {
        return repository;
    }
}