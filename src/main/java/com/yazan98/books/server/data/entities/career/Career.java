package com.yazan98.books.server.data.entities.career;

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
 * Time : 10:28 PM
 */

@Entity
@Table(name = "careers")
public class Career extends BaseModel implements Serializable {


    @Column(name = "name")
    private String name;


    @Column(name = "image")
    private String image;


    @Column(name = "description")
    private String description;


    @Column(name = "location")
    private String location;


    @Column(name = "positions")
    private Long positions;


    @ElementCollection
    private List<String> requirements = new ArrayList<>();


    @ElementCollection
    private List<String> competencies = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private CareerEducation education;

    @OneToOne(cascade = CascadeType.ALL)
    private CareerExperience experience;

    public Career() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getPositions() {
        return positions;
    }

    public void setPositions(Long positions) {
        this.positions = positions;
    }

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }

    public List<String> getCompetencies() {
        return competencies;
    }

    public void setCompetencies(List<String> competencies) {
        this.competencies = competencies;
    }

    public CareerEducation getEducation() {
        return education;
    }

    public void setEducation(CareerEducation education) {
        this.education = education;
    }

    public CareerExperience getExperience() {
        return experience;
    }

    public void setExperience(CareerExperience experience) {
        this.experience = experience;
    }
}
