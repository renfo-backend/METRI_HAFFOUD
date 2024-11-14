package fr.projet.optmisationDb.DTO;

import fr.projet.optmisationDb.Entity.Interest;
import fr.projet.optmisationDb.Entity.Notification;
import fr.projet.optmisationDb.Entity.ParticipationRequest;
import fr.projet.optmisationDb.Entity.Party;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsersDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private Long id;

    private String username;
    private String email;
    private String name;
    private String surname;
    private int age;
    private float rating;
    private String city;
    private String password;


    private List<NotificationDTO> notifications=new ArrayList<>();

    private List<InterestDTO> interests=new ArrayList<>();

    private List<PartyDTO> party=new ArrayList<>();

    private List<ParticipationRequestDTO> participationRequests=new ArrayList<>();

    private List<PartyDTO> organizedParties=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<NotificationDTO> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationDTO> notifications) {
        this.notifications = notifications;
    }

    public List<InterestDTO> getInterests() {
        return interests;
    }

    public void setInterests(List<InterestDTO> interests) {
        this.interests = interests;
    }

    public List<PartyDTO> getParty() {
        return party;
    }

    public void setParty(List<PartyDTO> party) {
        this.party = party;
    }

    public List<ParticipationRequestDTO> getParticipationRequests() {
        return participationRequests;
    }

    public void setParticipationRequests(List<ParticipationRequestDTO> participationRequests) {
        this.participationRequests = participationRequests;
    }

    public List<PartyDTO> getOrganizedParties() {
        return organizedParties;
    }

    public void setOrganizedParties(List<PartyDTO> organizedParties) {
        this.organizedParties = organizedParties;
    }

    @Override
    public String toString() {
        return "UsersDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
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
}
