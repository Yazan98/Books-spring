package com.yazan98.books.server.data.entities.book;

import com.yazan98.books.server.data.BaseModel;
import com.yazan98.books.server.data.entities.aother.Author;
import com.yazan98.books.server.utils.BookStatus;
import org.jsondoc.core.annotation.ApiObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/25/2019
 * Time : 2:24 AM
 */

@Entity
@Table(name = "books")
@ApiObject
public class Book extends BaseModel implements Serializable {


    @Column(name = "name")
    private String title;


    @Column(name = "image")
    private String image;


    @Column(name = "cover")
    private String cover;


    @Column(name = "bio")
    private String bio;


    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> chapters = new ArrayList<>();


    @Column(name = "status")
    private BookStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;


    @Column(name = "price")
    private Double price;


    @Column(name = "category")
    private String category;


    @Column(name = "year")
    private Long year;


    @Column(name = "available")
    private Boolean available;


    @OneToOne(cascade = CascadeType.ALL)
    private Publisher publisher;

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<String> getChapters() {
        return chapters;
    }

    public void setChapters(List<String> chapters) {
        this.chapters = chapters;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
