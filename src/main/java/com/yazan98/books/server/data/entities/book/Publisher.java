package com.yazan98.books.server.data.entities.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yazan98.books.server.data.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/25/2019
 * Time : 2:59 AM
 */

@Entity
@Table(name = "publishers")
public class Publisher extends BaseModel implements Serializable {


    @Column(name = "name")
    private String name;


    @Column(name = "image")
    private String image;

    @OneToOne
    @JsonIgnore
    private Book book;

    public Publisher() {

    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
