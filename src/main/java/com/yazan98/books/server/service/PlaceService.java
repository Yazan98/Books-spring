package com.yazan98.books.server.service;

import com.yazan98.books.server.data.entities.Place;
import com.yazan98.books.server.data.repos.PlaceRepository;
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
 * Date : 8/24/2019
 * Time : 4:40 PM
 */

@Service
@Transactional
public class PlaceService extends BaseService<Place, PlaceRepository> {

    private final PlaceRepository repository;

    @Autowired
    public PlaceService(PlaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Place save(Place place) throws InvalidValueException, NotFoundException {
        if (place.getName() == null) {
            throw new InvalidValueException("Place Name Missing");
        } else if (place.getLatitude() == null) {
            throw new InvalidValueException("Place Latitude Missing");
        } else if (place.getLongitude() == null) {
            throw new InvalidValueException("Place Longitude Missing");
        } else {
            getRepository().save(place);
            return getById(place.getId());
        }
    }

    @Override
    public PlaceRepository getRepository() {
        return repository;
    }
}
