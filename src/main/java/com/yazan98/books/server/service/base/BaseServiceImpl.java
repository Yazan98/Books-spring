package com.yazan98.books.server.service.base;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 9:27 AM
 */

import com.yazan98.books.server.data.BaseModel;
import com.yazan98.books.server.exception.InvalidValueException;
import com.yazan98.books.server.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseServiceImpl<Entity extends BaseModel, Repository extends JpaRepository<Entity, Long>> {

    Entity save(Entity entity) throws InvalidValueException, NotFoundException;

    Entity getById(Long id) throws NotFoundException;

    List<Entity> getAll() throws NotFoundException;

    Boolean deleteById(Long id) throws NotFoundException;

    void deleteAll() throws NotFoundException;

    Boolean getRepositoryStatus(Repository repository);

    Repository getRepository();

}