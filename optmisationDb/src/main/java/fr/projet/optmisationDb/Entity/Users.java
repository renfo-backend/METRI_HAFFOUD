package fr.projet.optmisationDb.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
//@Getter
//@Setter
//@ToString
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

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", rating=" + rating +
                ", city='" + city + '\'' +
                ", password='" + password + '\'' +
                ", notifications=" + notifications +
                ", interests=" + interests +
                ", party=" + party +
                ", participationRequests=" + participationRequests +
                ", organizedParties=" + organizedParties +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public List<Party> getParty() {
        return party;
    }

    public void setParty(List<Party> party) {
        this.party = party;
    }

    public List<ParticipationRequest> getParticipationRequests() {
        return participationRequests;
    }

    public void setParticipationRequests(List<ParticipationRequest> participationRequests) {
        this.participationRequests = participationRequests;
    }

    public List<Party> getOrganizedParties() {
        return organizedParties;
    }

    public void setOrganizedParties(List<Party> organizedParties) {
        this.organizedParties = organizedParties;
    }
}
