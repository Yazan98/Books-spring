package com.yazan98.books.server.data.entities.career;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * Date : 8/26/2019
 * Time : 10:41 PM
 */

@Entity
@Table(name = "experience")
public class CareerExperience extends BaseModel implements Serializable {


    @Column(name = "years")
    private Long years;


    @Column(name = "description")
    private String description;


    @ElementCollection
    private List<String> languages = new ArrayList<>();

    @OneToOne
    @JsonIgnore
    private Career career;

    public CareerExperience() {

    }

    public Long getYears() {
        return years;
    }

    public void setYears(Long years) {
        this.years = years;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }
}
