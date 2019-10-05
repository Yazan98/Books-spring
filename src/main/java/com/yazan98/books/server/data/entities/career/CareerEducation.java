package com.yazan98.books.server.data.entities.career;

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
 * Date : 8/26/2019
 * Time : 10:34 PM
 */

@Entity
@Table(name = "education")
public class CareerEducation extends BaseModel implements Serializable {


    @Column(name = "degree")
    private String degree;


    @Column(name = "university_name")
    private String universityName;


    @Column(name = "graduation_year")
    private Long graduationYear;


    @Column(name = "type")
    private String type; // fresh or not

    @OneToOne
    @JsonIgnore
    private Career career;

    public CareerEducation() {

    }

    public String getDegree() {
        return degree;
    }

    public String getUniversityName() {
        return universityName;
    }

    public Long getGraduationYear() {
        return graduationYear;
    }

    public String getType() {
        return type;
    }

    public Career getCareer() {
        return career;
    }
}
