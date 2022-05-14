package com.sportyshoes;


import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SportyshoesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyshoesApiApplication.class, args);
		System.out.println("sportyshoes-api works!");
	}
	
	@Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.spring.boot.project.sportyshoes.demo"))
                .build()
                .apiInfo(apiDetails());
    }
    
    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Sportyshoes API",
                "Spring Boot REST API for sportyshoes.com",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Shruti Sharma", "https://github.com/shruti-bhrdwj/", "mfs.akash@gmail.com"),
                "API License",
                "https://github.com/akash-coded/",
                Collections.emptyList()
                );
    }
	
}
