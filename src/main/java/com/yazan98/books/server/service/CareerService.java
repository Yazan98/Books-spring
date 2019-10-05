package com.yazan98.books.server.service;

import com.yazan98.books.server.data.entities.career.Career;
import com.yazan98.books.server.data.repos.CareerRepository;
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
 * Date : 8/26/2019
 * Time : 10:44 PM
 */

@Service
@Transactional
public class CareerService extends BaseService<Career, CareerRepository> {

    private final CareerRepository repository;

    @Autowired
    public CareerService(CareerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Career save(Career career) throws InvalidValueException, NotFoundException {
        getRepository().save(career);
        return getById(career.getId());
    }

    @Override
    public CareerRepository getRepository() {
        return repository;
    }
}
