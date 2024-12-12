package fr.projet.duo.optimisation.Entity.Request;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeStatusRequest {
    private Long id;
    private String status;
}
