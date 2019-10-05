package com.yazan98.books.server.controller;

import com.yazan98.books.server.data.BaseModel;
import com.yazan98.books.server.exception.InvalidValueException;
import com.yazan98.books.server.exception.NotFoundException;
import com.yazan98.books.server.response.BaseResponse;
import com.yazan98.books.server.response.SuccessResponse;
import com.yazan98.books.server.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 9:38 AM
 */
public class BaseController<Entity extends BaseModel, Repository extends JpaRepository<Entity, Long>, Service extends BaseService<Entity, Repository>> {

    @Autowired
    private Service service;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> saveEntity(@Valid @RequestBody Entity entity) throws NotFoundException, InvalidValueException {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new SuccessResponse(
                        String.valueOf(HttpStatus.CREATED.value()),
                        "Data Saved At Database",
                        HttpStatus.CREATED.value(),
                        getService().save(entity)
                )
        );
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET , path = "/id")
    public ResponseEntity<BaseResponse> getEntityById(@PathParam("id") Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse(
                        String.valueOf(HttpStatus.OK.value()),
                        "Data Found",
                        HttpStatus.OK.value(),
                        getService().getById(id)
                )
        );
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<BaseResponse> getAllEntities() throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse(
                        String.valueOf(HttpStatus.OK.value()),
                        "Data Saved At Database",
                        HttpStatus.OK.value(),
                        getService().getAll()
                )
        );
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE , path = "/id")
    public ResponseEntity<BaseResponse> deleteEntityById(@PathParam("id") Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new SuccessResponse(
                        String.valueOf(HttpStatus.CREATED.value()),
                        "Data Deleted",
                        HttpStatus.CREATED.value(),
                        getService().deleteById(id)
                )
        );
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<BaseResponse> deleteAllEntities() throws NotFoundException {
        getService().deleteAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new SuccessResponse(
                        String.valueOf(HttpStatus.CREATED.value()),
                        "Data Deleted",
                        HttpStatus.CREATED.value(),
                        true
                )
        );
    }

    public Service getService() {
        return service;
    }

}
