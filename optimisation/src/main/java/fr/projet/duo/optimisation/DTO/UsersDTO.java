package fr.projet.duo.optimisation.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.projet.duo.optimisation.Entity.Interest;
import fr.projet.duo.optimisation.Entity.Notification;
import fr.projet.duo.optimisation.Entity.ParticipationRequest;
import fr.projet.duo.optimisation.Entity.Party;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private Long id;

    private String username;
    private String email;
    @JsonIgnore
    @ToStringExclude
    private AddressDTO address;
    private String name;
    private String surname;
    private int age;
    private float rating;
    private String city;
    @Schema(hidden = true)
    private String password;

    @ToStringExclude
    @JsonIgnore
    private List<NotificationDTO> notifications = new ArrayList<>();
    @JsonIgnore
    @ToStringExclude
    private List<InterestDTO> interests = new ArrayList<>();
    @JsonIgnore
    @ToStringExclude
    private List<PartyDTO> party = new ArrayList<>();
    @JsonIgnore
    @ToStringExclude
    private List<ParticipationRequestDTO> participationRequests = new ArrayList<>();
    @JsonIgnore
    @ToStringExclude
    private List<PartyDTO> organizedParties = new ArrayList<>();




}
