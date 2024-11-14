package fr.projet.duo.optimisation.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.projet.duo.optimisation.Entity.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private Long id;
    private String message;
    private boolean isRead;

    @ToStringExclude
    @JsonIgnore
    private UsersDTO users;


}
