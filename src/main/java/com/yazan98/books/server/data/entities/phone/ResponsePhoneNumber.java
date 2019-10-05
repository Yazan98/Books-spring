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
public class ResponsePhoneNumber {

    private String accountStatus;
    private boolean accountVarifyStatus;
    private String phoneNumber;

    public ResponsePhoneNumber(){

    }

    public ResponsePhoneNumber(String accountStatus, boolean accountVarifyStatus, String phoneNumber) {
        this.accountStatus = accountStatus;
        this.accountVarifyStatus = accountVarifyStatus;
        this.phoneNumber = phoneNumber;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public boolean isAccountVarifyStatus() {
        return accountVarifyStatus;
    }

    public void setAccountVarifyStatus(boolean accountVarifyStatus) {
        this.accountVarifyStatus = accountVarifyStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
