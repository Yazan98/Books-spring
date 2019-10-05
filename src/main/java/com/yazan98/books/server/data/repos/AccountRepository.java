package com.yazan98.books.server.data.repos;

import com.yazan98.books.server.data.entities.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 9:29 AM
 */

@Repository
public interface AccountRepository extends JpaRepository<Account , Long> {

    Optional<Account> findByEmailAndPassword(String email , String password);

    Optional<Account> findByEmail(String email);

    Optional<Account> findByPhoneNumber(String phoneNumber);

    Optional<Account> findByUsername(String username);

}
