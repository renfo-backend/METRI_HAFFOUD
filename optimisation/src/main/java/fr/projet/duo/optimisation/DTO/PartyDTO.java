package fr.projet.duo.optimisation.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.projet.duo.optimisation.Entity.PartyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartyDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private Long id;
    private String name;
    @JsonIgnore
    @ToString.Exclude
    private AddressDTO location;
    private String dateParty;
    private int capacity;
    private boolean isPaid;
    private float price;
    private boolean isPublished;
    @JsonIgnore
    @ToString.Exclude
    private List<UsersDTO> participant=new ArrayList<>();
    @JsonIgnore
    @ToString.Exclude
    private List<MessageDTO> messages=new ArrayList<>();
    @JsonIgnore
    @ToString.Exclude
    private List<ParticipationRequestDTO> participationRequests=new ArrayList<>();

    private PartyTypeDTO partyType;
    private UsersDTO organizer;


}
