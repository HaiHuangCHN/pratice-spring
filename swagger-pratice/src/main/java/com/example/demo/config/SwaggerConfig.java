package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 configuration class<br>
 * By adding @Configuration annotation, delegate Spring to manage<br>
 * By adding @EnableSwagger2 to enable swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Create apiInfo() to display more info of the API<br>
	 * Use select() to return ApiSelectorBuilder instance to control which interface
	 * to be displayed to Swagger<br>
	 * The example implement by scanning the specified package
	 * 
	 * @return
	 */
//	/**
//	 * Specify the package of APIs<br>
//	 * RequestHandlerSelectors.basePackage("com.example.demo.controller")
//	 */
//	@Bean
//	public Docket createRestApi() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")).paths(PathSelectors.any())
//				.build();
//	}

	/**
	 * All the APIs will be included<br>
	 * <RequestHandlerSelectors.any()>
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	/**
	 * Set up basic information, which will be displayed in the page<br>
	 * URL: http://(actual path of the project)/swagger-ui.html
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Use Swagger2 to build RESTful APIs on Spring Boot")
				.description("To get more info: http://www.baidu.com").termsOfServiceUrl("http://www.hai.huang.com")
				.license("LICENSE").licenseUrl("http://www.hai.huang.license.com").contact("hai.huang.a@outlook.com")
				.version("1.0").build();
	}

}
