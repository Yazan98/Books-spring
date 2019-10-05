package com.yazan98.books.server.data.repos;

import com.yazan98.books.server.data.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/25/2019
 * Time : 3:23 AM
 */

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<List<Review>> findAllByAccountId(Long accountId);

    Optional<List<Review>> findAllByBookId(Long bookId);

}
