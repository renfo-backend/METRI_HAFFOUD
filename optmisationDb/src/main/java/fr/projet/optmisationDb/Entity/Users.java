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
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String username;
    private String email;
    private int age;
    private float rating;
    private String city;
    private String password;

    @OneToMany(mappedBy = "users")
    private List<Notification> notifications;

    @ManyToMany
    @JoinTable(name = "users_interest")
    private List<Interest> interests;

    @ManyToMany(mappedBy = "participant")
    private List<Party> party;

    @OneToMany(mappedBy = "users")
    private List<ParticipationRequest> participationRequests;

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    private List<Party> organizedParties;
}
