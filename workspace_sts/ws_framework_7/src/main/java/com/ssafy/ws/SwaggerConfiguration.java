package com.ssafy.ws;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
//	Swagger-UI 확인
//	http://localhost:port/{your-app-root}/swagger-ui.html

	    @Bean
	    public Docket postsApi() {
	       final ApiInfo apiInfo = new ApiInfoBuilder()
	               .title("SSAFY WS_Framework_7 API")
	               .description("<h3>SSAFY 도서관리 API</h3>워크샵에서 사용되는 RestApi에 대한 문서를 제공한다.<br><img src=\"webimg/ssafy_logo.png\" width=\"150\">")
	               .contact(new Contact("SSAFY", "https://edu.ssafy.com", "ssafy@ssafy.com"))
	               .license("SSAFY License")
				   .licenseUrl("https://www.ssafy.com/ksp/jsp/swp/etc/swpPrivacy.jsp")
	               .version("1.0")
	               .build();
	       
	        Docket docket = new Docket(DocumentationType.SWAGGER_2)
	                .groupName("ssafyWSFrameworkApi")
	                .apiInfo(apiInfo)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.ssafy.ws.controller"))
	                .paths(postPaths())
	                .build();
	        System.out.println(docket);
	        return docket;
	    }

		private Predicate<String> postPaths() {
			return regex("/bookapi/.*");
		}
}
