package com.yazan98.books.server.data.repos;

import com.yazan98.books.server.data.entities.aother.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/24/2019
 * Time : 4:56 PM
 */

@Repository
public interface AuthorRepository extends JpaRepository<Author , Long> {

}
