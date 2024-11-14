package fr.projet.duo.optimisation.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ParticipationRequestDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private Long id;
    private String status;
    private UsersDTO usersDTO;
    private PartyDTO partyDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UsersDTO getUsersDTO() {
        return usersDTO;
    }

    public void setUsersDTO(UsersDTO usersDTO) {
        this.usersDTO = usersDTO;
    }

    public PartyDTO getPartyDTO() {
        return partyDTO;
    }

    public void setPartyDTO(PartyDTO partyDTO) {
        this.partyDTO = partyDTO;
    }

    @Override
    public String toString() {
        return "ParticipationRequestDTO{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", usersDTO=" + usersDTO +
                ", partyDTO=" + partyDTO +
                '}';
    }
}
