package com.yazan98.books.server.data.entities.phone;

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
 * Time : 4:04 PM
 */

@Entity
@Table(name = "phone_numbers")
@ApiObject
public class PhoneNumber extends BaseModel implements Serializable {


    @Column(name = "phone_number")
    private String phoneNumber;


    @Column(name = "code")
    private int code;


    @Column(name = "account_id")
    private Long accountId;


    @Column(name = "verified")
    private boolean verified;


    public PhoneNumber() {

    }

    public PhoneNumber(String phoneNumber, int code, Long accountId, boolean verified) {
        this.phoneNumber = phoneNumber;
        this.code = code;
        this.accountId = accountId;
        this.verified = verified;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public PhoneNumber(String phoneNumber, int code, Long accountId) {
        this.phoneNumber = phoneNumber;
        this.code = code;
        this.accountId = accountId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
