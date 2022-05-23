package com.my.dragon.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String BASE_PACKAGE = "com.my.dragon.controller";

    @Bean
    public Docket apiV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Dragons Api")
                .description("API para CRUD de dragoes")
                .version("1.0.0")
                .contact(new Contact("Joao Pedro", null,"joappedro@gmail.com" ))
                .build();
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .displayRequestDuration(Boolean.TRUE)
                .validatorUrl("")
                .build();
    }

}

