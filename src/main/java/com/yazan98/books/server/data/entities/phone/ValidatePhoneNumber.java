package com.yazan98.books.server.data.entities.phone;

import org.jsondoc.core.annotation.ApiObject;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 4:05 PM
 */

@ApiObject
public class ValidatePhoneNumber {

    private String phoneNumber;
    private int code;

    public ValidatePhoneNumber(){

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
