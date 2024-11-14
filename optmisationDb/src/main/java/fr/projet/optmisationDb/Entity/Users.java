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
    private String email;
    private int age;
    private float rating;
    private String city;
    private String password;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_interest",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id"))
    private List<Interest> interests;

    @ManyToMany(mappedBy = "participants", cascade = CascadeType.ALL)
    private List<Party> parties;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<ParticipationRequest> participationRequests;

}
