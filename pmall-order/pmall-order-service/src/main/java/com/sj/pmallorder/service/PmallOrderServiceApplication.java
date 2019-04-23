package com.sj.pmallorder.service;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan("com.sj.pmallorder.service.mapper")
public class PmallOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmallOrderServiceApplication.class, args);
    }

}
