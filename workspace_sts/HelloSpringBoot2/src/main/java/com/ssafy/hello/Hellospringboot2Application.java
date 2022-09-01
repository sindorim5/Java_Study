package com.ssafy.hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan("com.ssafy.hello.guestbook.model.mapper")
public class Hellospringboot2Application {

    public static void main(String[] args) {
		SpringApplication.run(Hellospringboot2Application.class, args);
//        new SpringApplicationBuilder(Hellospringboot2Application.class)
//        .properties("spring.config.location=classpath:/application.properties, ./conf/settings.properties")
//        .run(args);

    }

}
