package com.ssafy.hellocors1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Hellocors1Application {
    /* 8080 서버 */
    
    
//    @CrossOrigin(origins = "http://localhost:18080")
    @GetMapping("/hello")
    public String hello() {
        return "hello. 8080~";
    }
    
    
	public static void main(String[] args) {
		SpringApplication.run(Hellocors1Application.class, args);
	}

}
