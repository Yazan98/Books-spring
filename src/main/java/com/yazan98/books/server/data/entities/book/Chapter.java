package com.yazan98.books.server.data.entities.book;

import com.yazan98.books.server.data.BaseModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/27/2019
 * Time : 2:18 AM
 */

@Entity
@Table(name = "chapters")
public class Chapter extends BaseModel implements Serializable {

    @Column(name = "name")
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<ChapterElement> elements = new ArrayList<>();

    public Chapter() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChapterElement> getElements() {
        return elements;
    }

    public void setElements(List<ChapterElement> elements) {
        this.elements = elements;
    }
}
