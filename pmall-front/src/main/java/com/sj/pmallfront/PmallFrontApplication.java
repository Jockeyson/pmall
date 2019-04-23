package com.sj.pmallfront;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDubboConfiguration
@ComponentScan(basePackages = {"com.sj.pmallfront","com.sj.pmallcommon"})
public class PmallFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmallFrontApplication.class, args);
    }

}
