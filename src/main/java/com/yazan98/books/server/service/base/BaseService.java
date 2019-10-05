package com.yazan98.books.server.service.base;

import com.yazan98.books.server.data.BaseModel;
import com.yazan98.books.server.exception.InvalidValueException;
import com.yazan98.books.server.exception.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 9:28 AM
 */

@Service
@Transactional
public abstract class BaseService<Entity extends BaseModel, Repository extends JpaRepository<Entity, Long>>
        implements BaseServiceImpl<Entity, Repository> {

    @Override
    public Entity getById(Long id) throws NotFoundException {
        try {
            if (getRepositoryStatus(getRepository())) {
                return getRepository().findById(id).get();
            } else {
                throw new NotFoundException("Data Not Found");
            }
        } catch (NoSuchElementException ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }

    @Override
    public List<Entity> getAll() throws NotFoundException {
        try {
            if (getRepositoryStatus(getRepository())) {
                return getRepository().findAll();
            } else {
                throw new NotFoundException("Data Not Found");
            }
        } catch (EmptyResultDataAccessException ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }

    @Override
    public Boolean deleteById(Long id) throws NotFoundException {
        if (getRepositoryStatus(getRepository())) {
            getRepository().deleteById(id);
            try {
                getById(id);
                return false;
            } catch (NoSuchElementException ex) {
                return true;
            }
        } else {
            throw new NotFoundException("Data Not Found");
        }
    }

    @Override
    public void deleteAll() throws NotFoundException {
        if (getRepositoryStatus(getRepository())) {
            getRepository().deleteAll();
        } else {
            throw new NotFoundException("Data Not Found");
        }
    }

    public Boolean getRepositoryStatus(Repository repository) {
        return repository.count() > 0;
    }

    public abstract Entity save(Entity entity) throws InvalidValueException, NotFoundException;

}
