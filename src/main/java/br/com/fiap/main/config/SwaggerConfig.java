package br.com.fiap.main.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public OpenAPI configurationOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API para Gerenciamento de Cursos em uma Universidade")
                        .description("")
                        .contact(new Contact()
                                .name("Kaique Santos de Andrade - RM99562")
                                .name("Marcelo Augusto de Mello Paixão - RM99466")
                                .name("Rodrigo Batista Freire - RM99513")
                        )
                        .version("v0.0.1")
                );
    }
}
