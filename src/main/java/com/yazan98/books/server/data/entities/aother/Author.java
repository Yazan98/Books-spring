package com.yazan98.books.server.data.entities.aother;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yazan98.books.server.data.BaseModel;
import com.yazan98.books.server.data.entities.book.Book;
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
 * Date : 8/24/2019
 * Time : 4:54 PM
 */

@Entity
@Table(name = "authors")
@ApiObject
public class Author extends BaseModel implements Serializable {


    @Column(name = "name")
    private String name;


    @Column(name = "image")
    private String image;


    @Column(name = "bio")
    private String bio;


    @Column(name = "rating")
    private Float rating;

    @JsonIgnore
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<Book>();

    public Author() {

    }

    public Author(String name, String image, String bio, Float rating) {
        this.name = name;
        this.image = image;
        this.bio = bio;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
