package com.yazan98.books.server.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.yazan98.books.server.config.EmailConfiguration;
import com.yazan98.books.server.config.SmsConfig;
import com.yazan98.books.server.data.entities.Review;
import com.yazan98.books.server.data.entities.account.Account;
import com.yazan98.books.server.data.entities.phone.PhoneNumber;
import com.yazan98.books.server.data.repos.AccountRepository;
import com.yazan98.books.server.data.repos.ReviewRepository;
import com.yazan98.books.server.exception.InvalidValueException;
import com.yazan98.books.server.exception.NotFoundException;
import com.yazan98.books.server.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 9:26 AM
 */

@Service
@Transactional
public class AccountService extends BaseService<Account, AccountRepository> {

    private final AccountRepository repository;
    private final ReviewRepository reviewRepository;
    private final SmsConfig smsConfig;
    private final PhoneNumberService phoneNumberService;
    private final EmailConfiguration emailConfiguration;

    @Autowired
    public AccountService(AccountRepository repository, SmsConfig smsConfig, PhoneNumberService phoneNumberService, EmailConfiguration emailConfiguration, ReviewRepository reviewRepository) {
        this.repository = repository;
        this.smsConfig = smsConfig;
        this.phoneNumberService = phoneNumberService;
        this.emailConfiguration = emailConfiguration;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Account save(Account account) throws InvalidValueException, NotFoundException {
        if (account.getUsername() == null) {
            throw new InvalidValueException("Username Missing");
        } else if (account.getEmail() == null) {
            throw new InvalidValueException("Email Missing");
        } else if (account.getImage() == null) {
            throw new InvalidValueException("Image Missing");
        } else if (account.getLocation() == null) {
            throw new InvalidValueException("Location Missing");
        } else if (account.getPassword() == null) {
            throw new InvalidValueException("Password Missing");
        } else if (account.getPhoneNumber() == null) {
            throw new InvalidValueException("Phone Number Missing");
        } else {

            if (!account.getPhoneNumber().startsWith("+962")) {
                account.setPhoneNumber("+962" + account.getPhoneNumber().substring(1));
            }

            account.setStatus("NOT_COMPLETED");
            int code = phoneNumberService.generateCode();
            getRepository().save(account);

            new Thread(() -> smsConfig.sendSms(
                    "Booking System",
                    "Welcome To Booking System Mr " + account.getUsername() +
                            "You Can Verify The Account With This Code : " + code,
                    account.getPhoneNumber()
            )).start();

            new Thread(() -> {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(account.getEmail());
                message.setSubject("Booking System - New Account Registered");
                message.setText("Welcome To Booking System Mr " + account.getUsername() +
                        "You Can Verify The Account With This Code : " + code);
                emailConfiguration.getJavaMailSender().send(
                        message
                );
            }).start();

            phoneNumberService.save(new PhoneNumber(
                    account.getPhoneNumber(),
                    code,
                    account.getId()
            ));

            return getById(account.getId());
        }
    }

    public Account login(String email, String password) throws InvalidValueException, NotFoundException {
        if (email == null) {
            throw new InvalidValueException("Email Missing");
        } else if (password == null) {
            throw new InvalidValueException("Password Missing");
        } else {
            return getRepository().findByEmailAndPassword(email, password)
                    .orElseThrow(NotFoundException::new);
        }
    }

    public Account getByPhoneNumber(String phoneNumber) throws NotFoundException {
        return getRepository().findByPhoneNumber(phoneNumber).orElseThrow(NotFoundException::new);
    }

    public void verify(Account account) {
        getRepository().save(account);
    }

    @Override
    public AccountRepository getRepository() {
        return repository;
    }

    public List<Review> getReviewsByAccountId(Long accountId) throws NotFoundException {
        return reviewRepository.findAllByAccountId(accountId)
                .orElseThrow(NotFoundException::new);
    }

    public void addAccountToFirebase(Account account) {
        new Thread(() -> {
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(account.getEmail())
                    .setEmailVerified(account.isActive())
                    .setPassword(account.getPassword())
                    .setPhoneNumber(account.getPhoneNumber())
                    .setDisplayName(account.getUsername())
                    .setPhotoUrl(account.getImage())
                    .setDisabled(false);

            UserRecord userRecord = null;
            try {
                userRecord = FirebaseAuth.getInstance().createUser(request);
            } catch (FirebaseAuthException e) {
                e.printStackTrace();
            }
            assert userRecord != null;
            System.out.println("Successfully created new user: " + userRecord.getUid());
        }).start();
    }
}
