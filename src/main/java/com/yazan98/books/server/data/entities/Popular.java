package com.yazan98.books.server.data.entities;

import com.yazan98.books.server.data.BaseModel;
import org.jsondoc.core.annotation.ApiObject;

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
 * Time : 2:25 AM
 */

@Entity
@Table(name = "populars")
@ApiObject
public class Popular extends BaseModel implements Serializable {


    @Column(name = "name")
    private String name;


    @Column(name = "image")
    private String image;

    @Column(name = "rating")
    private Float rating;


    @Column(name = "price")
    private String price;

    public Popular() {

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

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
