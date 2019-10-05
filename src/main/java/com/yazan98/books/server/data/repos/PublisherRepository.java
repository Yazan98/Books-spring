package com.yazan98.books.server.data.repos;

import com.yazan98.books.server.data.entities.book.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/25/2019
 * Time : 3:04 AM
 */

@Repository
public interface PublisherRepository extends JpaRepository<Publisher , Long> {
}
