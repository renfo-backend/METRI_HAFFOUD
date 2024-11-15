package fr.projet.duo.optimisation.Entity.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginRequest {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private String username;
    private String password;

}
