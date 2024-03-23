package com.app.ceo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PathMatcher;

import java.util.Collections;
@OpenAPIDefinition
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springCEOOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Gestion des residences API Documentation")
                        .description("Gestion de stock rest api")
                        .contact(new Contact().email("rbahihoudaifa5@gmail.com")
                                .name("Houdaifa R'bahi"))).
                servers(Collections.singletonList(new Server().url("http://localhost:8083")))


                ;
    }
}
