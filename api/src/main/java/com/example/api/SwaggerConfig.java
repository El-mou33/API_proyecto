package com.example.api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {


    @Bean
    public OpenAPI customOpenApi(){
        SwaggerParseResult parseResult =new OpenAPIV3Parser().readLocation("swagger.yml",null,null);

        if (!parseResult.getMessages().isEmpty()) {
            parseResult.getMessages().forEach(System.err::println);
            return new OpenAPI();
        }

        return parseResult.getOpenAPI();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }
}
