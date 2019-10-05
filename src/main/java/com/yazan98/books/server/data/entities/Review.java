package com.yazan98.books.server.data.entities;

import com.yazan98.books.server.data.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/25/2019
 * Time : 3:21 AM
 */

@Entity
@Table(name = "reviews")
public class Review extends BaseModel implements Serializable {


    @Column(name = "rating")
    private Float rating;


    @Column(name = "review")
    private String review;


    @Column(name = "accountId")
    private Long accountId;

    @Column(name = "bookId")
    private Long bookId;

    public Review() {

    }

    public Long getBookId() {
        return bookId;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
