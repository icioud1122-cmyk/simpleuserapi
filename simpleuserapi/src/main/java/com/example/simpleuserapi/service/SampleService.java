package com.example.simpleuserapi.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private final JdbcTemplate jdbcTemplate;

    public SampleService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert() {
        jdbcTemplate.update(
                "INSERT INTO new_test_tbl (testpk, column_test) VALUES (?, ?)",
                "id003",
                "from spring"
        );
    }
}
