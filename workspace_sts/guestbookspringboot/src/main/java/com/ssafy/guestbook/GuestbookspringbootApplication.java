package com.ssafy.guestbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ssafy.guestbook.model.mapper")
public class GuestbookspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestbookspringbootApplication.class, args);
	}
}
