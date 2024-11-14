package fr.projet.optmisationDb.DTO;

import fr.projet.optmisationDb.Entity.Message;
import fr.projet.optmisationDb.Entity.ParticipationRequest;
import fr.projet.optmisationDb.Entity.PartyType;
import fr.projet.optmisationDb.Entity.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartyDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private Long id;
    private String name;
    private String location;
    private String date_party;
    private int capacity;
    private boolean isPaid;
    private float price;

    private List<Users> participant;

    private List<Message> messages;

    private List<ParticipationRequest> participationRequests;

    private PartyType partyType;
    private Users organizer;
}
