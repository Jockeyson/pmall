package com.sj.pmallgoods.service;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDubboConfiguration
//@EnableTransactionManagement
//@EnableAspectJAutoProxy
public class PmallGoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmallGoodsServiceApplication.class, args);
    }

}
