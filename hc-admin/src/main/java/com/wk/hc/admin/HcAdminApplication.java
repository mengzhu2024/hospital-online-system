package com.wk.hc.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.wk.hc.*.mapper")
@SpringBootApplication(scanBasePackages = "com.wk.hc")
public class HcAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(HcAdminApplication.class, args);
    }
}
