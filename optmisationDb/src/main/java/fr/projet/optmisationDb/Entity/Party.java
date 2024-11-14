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
    private String date_party;
    private int capacity;
    private boolean isPaid;
    private float price;

    @ManyToMany
    @JoinTable(name = "party_participants",
            joinColumns = @JoinColumn(name = "party_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Users> participants;

    @OneToMany(mappedBy = "party")
    private List<Message> messages;

    @OneToMany(mappedBy = "party")
    private List<ParticipationRequest> participationRequests;

    @ManyToOne
    @JoinColumn(name = "party_type_id")
    private PartyType partyType;

    // Getters and Setters
}
