package com.swap.pivot.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Pivot Points API")
                        .description("Pivot API to return Pivot High and Pivot Low data based on Stock Data")
                        .termsOfService("terms")
                        .version("1.0")
                );
    }
}
