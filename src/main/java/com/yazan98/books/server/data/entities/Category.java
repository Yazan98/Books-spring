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
 * Date : 8/26/2019
 * Time : 10:21 PM
 */

@Entity
@Table(name = "categories")
public class Category extends BaseModel implements Serializable {


    @Column(name = "name")
    private String name;


    @Column(name = "description")
    private String description;


    @Column(name = "image")
    private String image;

    public Category() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
