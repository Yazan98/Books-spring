package com.yazan98.books.server.service;

import com.yazan98.books.server.data.entities.Review;
import com.yazan98.books.server.data.entities.book.Book;
import com.yazan98.books.server.data.repos.BookRepository;
import com.yazan98.books.server.data.repos.ReviewRepository;
import com.yazan98.books.server.exception.InvalidValueException;
import com.yazan98.books.server.exception.NotFoundException;
import com.yazan98.books.server.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/25/2019
 * Time : 2:39 AM
 */

@Service
@Transactional
public class BookService extends BaseService<Book, BookRepository> {

    private final BookRepository repository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public BookService(BookRepository repository, ReviewRepository reviewRepository) {
        this.repository = repository;
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Book save(Book book) throws InvalidValueException, NotFoundException {
        if (book.getAuthor() == null) {
            throw new InvalidValueException("Book Author Missing");
        } else if (book.getBio() == null) {
            throw new InvalidValueException("Book Bio Missing");
        } else if (book.getChapters() == null) {
            throw new InvalidValueException("Book Chapters Missing");
        } else if (book.getCover() == null) {
            throw new InvalidValueException("Book Cover Missing");
        } else if (book.getImage() == null) {
            throw new InvalidValueException("Book Image Missing");
        } else if (book.getTitle() == null) {
            throw new InvalidValueException("Book Title Missing");
        } else if (book.getStatus() == null) {
            throw new InvalidValueException("Book Status Missing");
        } else {
            getRepository().save(book);
            return getById(book.getId());
        }
    }

    public List<Review> getReviewsByBookId(Long bookId) throws NotFoundException {
        return reviewRepository.findAllByBookId(bookId)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public BookRepository getRepository() {
        return repository;
    }
}
