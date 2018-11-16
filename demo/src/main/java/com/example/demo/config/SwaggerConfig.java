package com.example.demo.config;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.Sets;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{
    @Bean
    public Docket api()
    {
        List<ResponseMessage> responseTypes = new ArrayList<ResponseMessage>();
        responseTypes.add(new ResponseMessageBuilder().code(401).message("Unauthorized").build());
        responseTypes.add(new ResponseMessageBuilder().code(403).message("Forbidden").build());
        responseTypes.add(new ResponseMessageBuilder().code(404).message("Not Found").build());

        Contact contact = new Contact("AM", null, "mahajan_aashish@hotmail.com");
        ApiInfo apiInfo = new ApiInfo(
                "altimetrixDemo",
                "",
                "v0.1",
                null,
                contact,
                null,
                null);

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.any()).build().useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseTypes)
                .globalResponseMessage(RequestMethod.HEAD, responseTypes)
                .directModelSubstitute(Timestamp.class, java.util.Date.class)
                .consumes(Sets.newHashSet("application/json")).produces(Sets.newHashSet("application/json"));
    }
}

