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
 * Date : 8/24/2019
 * Time : 4:37 PM
 */

@Entity
@Table(name = "places")
@ApiObject
public class Place extends BaseModel implements Serializable {


    @Column(name = "name")
    private String name;


    @Column(name = "latitude")
    private Double latitude;


    @Column(name = "longitude")
    private Double longitude;

    public Place() {

    }

    public Place(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
