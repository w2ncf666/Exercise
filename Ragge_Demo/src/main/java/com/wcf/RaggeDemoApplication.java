package com.wcf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class RaggeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaggeDemoApplication.class, args);
    }

}
