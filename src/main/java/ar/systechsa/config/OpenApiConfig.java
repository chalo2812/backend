package ar.systechsa.config;

import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
//import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(info = @Info(title = "${springdoc.title}", //version = "1.0",
            contact = @Contact(name = "Soporte", email = "soporte@systechasa.com", url = "https://www.systechasa.com"),
            license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"),
            termsOfService = "${tos.uri}",
            description = "${api.description}",
            version = "${spring.application.version}"),
            security = @SecurityRequirement(name = "Authentication")
        )
@SecurityScheme(name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    description = "Bearer Authentication for API access",
    scheme = "bearer")
public class OpenApiConfig {
}
