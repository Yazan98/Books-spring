package com.yazan98.books.server.config;

import com.yazan98.books.server.data.entities.account.Account;
import com.yazan98.books.server.data.entities.phone.PhoneNumber;
import com.yazan98.books.server.data.repos.AccountRepository;
import com.yazan98.books.server.data.repos.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 4:28 PM
 */

@Configuration
public class ApplicationStartup implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final PhoneNumberRepository phoneNumberRepository;

    public ApplicationStartup(AccountRepository accountRepository, PhoneNumberRepository phoneNumberRepository) {
        this.accountRepository = accountRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }


    public void registerMainAccount() {
        Account account = new Account(
                "Yazan Tarifi",
                "yazan@gmail.com",
                "123456789",
                "Amman , Jordan",
                "https://test.test",
                "+962785465322",
                true,
                "Male",
                "16/11/1998",
                Collections.emptyList(),
                "COMPLETED"
        );

        accountRepository.save(account);

        phoneNumberRepository.save(new PhoneNumber(
                "+962785465322",
                1234,
                account.getId(),
                true
        ));

    }

    @Override
    public void run(String... args) throws Exception {
        registerMainAccount();
    }
}
