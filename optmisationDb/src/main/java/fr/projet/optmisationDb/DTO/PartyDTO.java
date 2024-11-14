package fr.projet.optmisationDb.DTO;

import fr.projet.optmisationDb.Entity.Message;
import fr.projet.optmisationDb.Entity.ParticipationRequest;
import fr.projet.optmisationDb.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartyDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private Long id;
    private String name;
    private String location;
    private String dateParty;
    private int capacity;
    private boolean isPaid;
    private float price;

    private List<UsersDTO> participant=new ArrayList<>();

    private List<MessageDTO> messages=new ArrayList<>();

    private List<ParticipationRequestDTO> participationRequests=new ArrayList<>();

    private String partyType;
    private UsersDTO organizer;

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

    public String getDate_party() {
        return dateParty;
    }

    public void setDate_party(String dateParty) {
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

    public List<UsersDTO> getParticipant() {
        return participant;
    }

    public void setParticipant(List<UsersDTO> participant) {
        this.participant = participant;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }

    public List<ParticipationRequestDTO> getParticipationRequests() {
        return participationRequests;
    }

    public void setParticipationRequests(List<ParticipationRequestDTO> participationRequests) {
        this.participationRequests = participationRequests;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public UsersDTO getOrganizer() {
        return organizer;
    }

    public void setOrganizer(UsersDTO organizer) {
        this.organizer = organizer;
    }

    @Override
    public String toString() {
        return "PartyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", dateParty='" + dateParty + '\'' +
                ", capacity=" + capacity +
                ", isPaid=" + isPaid +
                ", price=" + price +
                ", participant=" + participant +
                ", messages=" + messages +
                ", participationRequests=" + participationRequests +
                ", partyType='" + partyType + '\'' +
                ", organizer=" + organizer +
                '}';
    }
}
