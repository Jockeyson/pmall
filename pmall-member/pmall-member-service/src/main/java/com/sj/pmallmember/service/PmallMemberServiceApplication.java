package com.sj.pmallmember.service;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class PmallMemberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmallMemberServiceApplication.class, args);
    }

}
