package com.mt.mp.articlesmanagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfigDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.paths(PathSelectors.ant("/articles/*"))
                .apis(RequestHandlerSelectors.basePackage("com.mt.mp.articlesmanagement"))
                .build()
                .apiInfo(
                        new ApiInfo("Articles API", "API for articles management",
                                "1.0.0",
                                "private use",
                                new Contact("Mostafa TAFOUGALTI", "", "mtafougalti@gmail.com"),
                                "API License",
                                "",
                                Collections.emptyList())
                );
    }

}
