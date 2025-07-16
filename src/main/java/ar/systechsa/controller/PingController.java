package ar.systechsa.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;

@Tag(name = "Check", description = "Check API")  
@RestController (value = "checkController")
@RequestMapping(value = "/ping")
@SecurityScheme(name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    description = "Bearer Authentication for API access",
    scheme = "bearer")
public class PingController {

    public static final Logger logger = LoggerFactory.getLogger(PingController.class);

    @GetMapping(path = "")
    @Operation(description = "Endpoint para chequear que esta levantado", 
        responses = {
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    )
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> get() {
        logger.info("PingController.get - Endpoint called");
        return ResponseEntity.status(HttpStatus.OK).body("pong");
    
    }
        
}
