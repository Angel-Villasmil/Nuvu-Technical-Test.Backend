package cc.nuvu.technical.test.backend.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket apiDocket() {
	    return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("cc.nuvu.technical.test.backend.controller"))
	            .paths(PathSelectors.any())
	            .build()
	            .apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "PRUEBA TÉCNICA BACKEND", 
	      "OFERTA LABORAL NUVU - DESARROLLADOR BACK", 
	      "API Rest - JWT - MySQL - Spring Boot", 
	      "Version 1.0", 
	      new Contact("Angel Villasmil", "www.nuvu.cc", "aavillasmil@gmail.com"), 
	      "www.nuvu.cc", "www.nuvu.cc", Collections.emptyList());
	}
}