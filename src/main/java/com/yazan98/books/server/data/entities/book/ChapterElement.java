package com.yazan98.books.server.data.entities.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yazan98.books.server.data.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/27/2019
 * Time : 2:19 AM
 */

@Entity
@Table(name = "elements")
public class ChapterElement extends BaseModel implements Serializable {

    @Column(name = "content")
    private String content;

    @Column(name = "extention")
    private String extention;

    public ChapterElement() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }
}
