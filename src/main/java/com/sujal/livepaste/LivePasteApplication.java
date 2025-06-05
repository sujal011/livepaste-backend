package com.sujal.livepaste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.sujal.livepaste.repositories")
public class LivePasteApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivePasteApplication.class, args);
    }

}
