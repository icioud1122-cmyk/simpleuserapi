package com.example.simpleuserapi;

import com.example.simpleuserapi.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimpleuserapiApplicationDb implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SimpleuserapiApplicationDb.class);

    private final SampleService sampleService;

    public SimpleuserapiApplicationDb(SampleService sampleService) {
        log.info("【3】SimpleuserapiApplicationDb コンストラクタ実行（DI完了）");
        this.sampleService = sampleService;
    }

    @Override
    public void run(String... args) {
        log.info("【4】CommandLineRunner 実行開始（起動時処理）");
        int result = sampleService.update("id005","test005");
        log.info("【5】CommandLineRunner 実行完了（更新件数: {}）", result);
    }
}
