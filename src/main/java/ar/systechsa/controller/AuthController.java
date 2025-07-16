package ar.systechsa.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "AuthController",
    description = "Autorizacion para identificar a la persona")  
@RestController (value = "authController")
@RequestMapping(value = "/auth")
@SecurityScheme(name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    description = "Bearer Authentication for API access",
    scheme = "bearer")
public class AuthController {

    public static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping
    @Operation(description = "Chequear que esta levantado",
        responses = {
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    )
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> postAuth() {
        logger.info("AuthController.postAuth - Endpoint called");
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

}
