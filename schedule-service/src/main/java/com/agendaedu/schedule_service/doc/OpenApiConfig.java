package com.agendaedu.schedule_service.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        String url = "https://agenda-edu.up.railway.app";

        return new OpenAPI()
                .info(new Info()
                        .title("Agenda Edu - Schedule Service API")
                        .description("API para o gerenciamento de turmas")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Agenda Edu")
                                .url(url)
                                .email("kaua.a.silveira@hotmail.com"))
                        .license(new License()
                                .name("Licença - Agenda Edu")
                                .url(url)));
    }
}
