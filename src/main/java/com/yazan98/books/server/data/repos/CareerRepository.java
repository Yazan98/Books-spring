package com.yazan98.books.server.data.repos;

import com.yazan98.books.server.data.entities.career.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright (C) 2019 Slash IO
 * Licensed under the Apache License, Version 2.0
 * <p>
 * Created By : Yazan Tarifi
 * Date : 8/26/2019
 * Time : 10:43 PM
 */

@Repository
public interface CareerRepository extends JpaRepository<Career , Long> {
}
