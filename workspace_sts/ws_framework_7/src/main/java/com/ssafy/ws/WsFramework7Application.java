package com.ssafy.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ssafy.ws.model.repo")
public class WsFramework7Application {

	public static void main(String[] args) {
		SpringApplication.run(WsFramework7Application.class, args);
	}

}
