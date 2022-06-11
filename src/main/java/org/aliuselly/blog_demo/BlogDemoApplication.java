package org.aliuselly.blog_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableTransactionManagement   // 启动注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan("org.aliuselly.blog_demo.dao")
@EnableOpenApi   // swagger3 全局开启注解，如果没有这个，那么 3.0 版本就无法打开 api 的页面
@SpringBootApplication
public class BlogDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogDemoApplication.class, args);
    }

}
