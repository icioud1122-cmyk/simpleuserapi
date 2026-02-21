package com.example.simpleuserapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleuserapiApplication {

	private static final Logger log = LoggerFactory.getLogger(SimpleuserapiApplication.class);

	public static void main(String[] args) {
		log.info("========================================");
		log.info("【1】アプリケーション起動開始");
		log.info("========================================");
		SpringApplication.run(SimpleuserapiApplication.class, args);
		log.info("【2】Spring Boot アプリケーション起動完了");
	}

}
