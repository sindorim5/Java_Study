package com.ssafy.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ssafy.ws.dto.mapper")
public class WsFramework6Application {

	public static void main(String[] args) {
		SpringApplication.run(WsFramework6Application.class, args);
	}

}
