package fr.projet.optmisationDb.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
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
    private List<Users> participant=new ArrayList<>();

    @OneToMany(mappedBy = "party")
    private List<Message> messages=new ArrayList<>();

    @OneToMany(mappedBy = "party")
    private List<ParticipationRequest> participationRequests=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Users organizer;

    private String partyType;

    @Override
    public String toString() {
        return "Party{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", dateParty='" + dateParty + '\'' +
                ", capacity=" + capacity +
                ", isPaid=" + isPaid +
                ", price=" + price +
                ",partyType=" + partyType +
                ", participant=" + participant +
                ", messages=" + messages +
                ", participationRequests=" + participationRequests +
                ", partyType=" + partyType +
                ", organizer=" + organizer +
                '}';
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateParty() {
        return dateParty;
    }

    public void setDateParty(String dateParty) {
        this.dateParty = dateParty;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Users> getParticipant() {
        return participant;
    }

    public void setParticipant(List<Users> participant) {
        this.participant = participant;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<ParticipationRequest> getParticipationRequests() {
        return participationRequests;
    }

    public void setParticipationRequests(List<ParticipationRequest> participationRequests) {
        this.participationRequests = participationRequests;
    }



    public Users getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Users organizer) {
        this.organizer = organizer;
    }

    // Getters and Setters
}
