package fr.projet.optmisationDb.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "party")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    @Column(name = "date_party")
    private String dateParty;

    private int capacity;
    private boolean isPaid;
    private float price;

    @ManyToMany
    @JoinTable(name = "party_participants")
    private List<Users> participant;

    @OneToMany(mappedBy = "party")
    private List<Message> messages;

    @OneToMany(mappedBy = "party")
    private List<ParticipationRequest> participationRequests;

    @ManyToOne
    @JoinColumn(name = "party_type_id")
    private PartyType partyType;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Users organizer;


    // Getters and Setters
}
