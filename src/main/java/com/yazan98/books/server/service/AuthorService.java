package com.yazan98.books.server.service;

import com.yazan98.books.server.data.entities.aother.Author;
import com.yazan98.books.server.data.repos.AuthorRepository;
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
 * Time : 4:57 PM
 */

@Service
@Transactional
public class AuthorService extends BaseService<Author, AuthorRepository> {

    private final AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author save(Author author) throws InvalidValueException, NotFoundException {
        if (author.getName() == null) {
            throw new InvalidValueException("Author Name Missing");
        } else if (author.getBio() == null) {
            throw new InvalidValueException("Author Bio Missing");
        } else if (author.getImage() == null) {
            throw new InvalidValueException("Author Image Missing");
        } else if (author.getRating() == null) {
            throw new InvalidValueException("Author Rating Missing");
        } else {
            getRepository().save(author);
            return getById(author.getId());
        }
    }

    @Override
    public AuthorRepository getRepository() {
        return repository;
    }
}
