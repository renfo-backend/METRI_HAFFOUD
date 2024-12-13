package fr.projet.duo.optimisation;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestion des Soirées")
                        .version("1.0")
                        .description("Documentation de l'API pour la gestion des types de soirées, des votes et des propositions de jeux."));
    }
}

