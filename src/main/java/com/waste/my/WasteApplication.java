package com.waste.my;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WasteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WasteApplication.class, args);
    }

}
