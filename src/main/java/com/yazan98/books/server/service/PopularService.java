package com.yazan98.books.server.service;

import com.yazan98.books.server.data.entities.Popular;
import com.yazan98.books.server.data.repos.PopularRepository;
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
 * Date : 8/25/2019
 * Time : 2:26 AM
 */

@Service
@Transactional
public class PopularService extends BaseService<Popular, PopularRepository> {

    private final PopularRepository repository;

    @Autowired
    public PopularService(PopularRepository repository) {
        this.repository = repository;
    }

    @Override
    public Popular save(Popular popular) throws InvalidValueException, NotFoundException {
        if (popular.getImage() == null) {
            throw new InvalidValueException("Popular Image Missing");
        } else if (popular.getName() == null) {
            throw new InvalidValueException("Popular Name Missing");
        } else if (popular.getPrice() == null) {
            throw new InvalidValueException("Popular Price Missing");
        } else if (popular.getRating() == null) {
            throw new InvalidValueException("Popular Rating Missing");
        } else {
            getRepository().save(popular);
            return getById(popular.getId());
        }
    }

    @Override
    public PopularRepository getRepository() {
        return repository;
    }
}
