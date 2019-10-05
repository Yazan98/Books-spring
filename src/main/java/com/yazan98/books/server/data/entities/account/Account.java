package com.yazan98.books.server.data.entities.account;

import com.yazan98.books.server.data.BaseModel;
import org.jsondoc.core.annotation.ApiObject;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 9:20 AM
 */

@Entity
@Table(name = "accounts")
@ApiObject
public class Account extends BaseModel implements Serializable {

    @Column(name = "username")
    private String username;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @Size(min = 8, max = 25, message = "Min 8 , Max 25")
    private String password;

    @Column(name = "location")
    private String location;

    @Column(name = "image")
    private String image;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "active")
    private boolean active;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    private String birthday;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();


    @Column(name = "status")
    private String status;


    @Column(name = "type")
    private AccountType type;

    public Account() {

    }

    public Account(String username, @Email String email, @Size(min = 8, max = 25, message = "Min 8 , Max 25") String password, String location, String image, String phoneNumber, boolean active, String gender, String birthday, List<String> roles, String status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.location = location;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.gender = gender;
        this.birthday = birthday;
        this.roles = roles;
        this.status = status;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
