package br.com.restaurant_manager.restaurant_manager.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    public OpenAPI restaurantManager(){
        return new OpenAPI().info(new Info()
                .title("Restaurant Manager")
                .description("Projeto avaliativo para a fase 01 da Postech em Arquitetura e Desenvolvimento Java, consistente em desenvolver um backend completo e robusto utilizando o framework Spring Boot, com foco no gerenciamento de usuários, incluindo operações de criação, atualização, exclusão e validação de login.")
                .version("v0.0.1")
                .license(new License().name("Apache 2.0").url("https://github.com/zricardobraga"))
        );
    }

}
