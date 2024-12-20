package fr.projet.duo.optimisation.DTO;

import fr.projet.duo.optimisation.Entity.Party;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private Long id;
    private String content;
    private String date_send;
    @ToString.Exclude
    private UsersDTO users;
    @ToString.Exclude
    private PartyDTO party;


}
