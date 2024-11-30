package com.wk.hc.patient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.wk.hc.*.mapper")
@SpringBootApplication(scanBasePackages = "com.wk.hc")
public class HcPatientApplication {
    public static void main(String[] args) {
        SpringApplication.run(HcPatientApplication.class, args);
    }
}
