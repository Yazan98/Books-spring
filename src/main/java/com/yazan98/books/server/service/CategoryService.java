package com.yazan98.books.server.service;

import com.yazan98.books.server.data.entities.Category;
import com.yazan98.books.server.data.repos.CategoryRepository;
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
 * Time : 10:23 PM
 */

@Service
@Transactional
public class CategoryService extends BaseService<Category, CategoryRepository> {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category save(Category category) throws InvalidValueException, NotFoundException {
        if (category.getDescription() == null) {
            throw new InvalidValueException("Category Description Missing");
        } else if (category.getImage() == null) {
            throw new InvalidValueException("Category Image Missing");
        } else if (category.getName() == null) {
            throw new InvalidValueException("Category Name Missing");
        } else {
            getRepository().save(category);
            return getById(category.getId());
        }
    }

    @Override
    public CategoryRepository getRepository() {
        return repository;
    }
}
