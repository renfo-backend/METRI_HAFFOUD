package fr.projet.duo.optimisation.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
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
    private List<Notification> notifications = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "users_interest")
    @JsonIgnore
    @ToString.Exclude
    private List<Interest> interests = new ArrayList<>();

    @ManyToMany(mappedBy = "participant")
    @JsonIgnore
    @ToString.Exclude
    private List<Party> party = new ArrayList<>();

    @OneToMany(mappedBy = "users")
    private List<ParticipationRequest> participationRequests = new ArrayList<>();

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    private List<Party> organizedParties = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;


}
