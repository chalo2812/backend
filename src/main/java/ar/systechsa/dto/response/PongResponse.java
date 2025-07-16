package ar.systechsa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class PongResponse {

    @Getter
    private String body;

}
