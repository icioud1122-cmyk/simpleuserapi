package com.example.simpleuserapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SampleService {

    private static final Logger log = LoggerFactory.getLogger(SampleService.class);

    private final JdbcTemplate jdbcTemplate;

    public SampleService(JdbcTemplate jdbcTemplate) {
        log.info("  【SampleService】this.jdbcTemplate = jdbcTemplate;");
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public int update(String id, String value) {
        log.info("  【SampleService】トランザクション開始");
        log.info("  【SampleService】UPDATE実行: id={}, value={}", id, value);
        int count = jdbcTemplate.update(
                "UPDATE new_test_tbl SET column_test = ? WHERE testpk = ?",
                value, id
        );
        log.info("  【SampleService】UPDATE完了: 更新件数={}", count);
        log.info("  【SampleService】トランザクションコミット");
        return count;
    }

}
