package fr.projet.duo.optimisation.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.projet.duo.optimisation.DTO.AddressDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "party")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "date_party")
    private String dateParty;
    private int capacity;
    private boolean isPaid;
    private float price;

    @ManyToMany
    @JoinTable(name = "party_participants")
    @ToString.Exclude
    private List<Users> participant = new ArrayList<>();

    @OneToMany(mappedBy = "party")
    @JsonIgnore
    @ToStringExclude
    private List<Message> messages = new ArrayList<>();

    @OneToMany(mappedBy = "party")
    private List<ParticipationRequest> participationRequests = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    @ToString.Exclude
    private Users organizer;

    @ManyToOne
    @JoinColumn(name = "party_type_id")
    private PartyType partyType;
}
