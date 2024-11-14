package fr.projet.optmisationDb.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class InterestDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private Long id;
    private String name;
    private String description;

    private List<UsersDTO> users;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UsersDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UsersDTO> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "InterestDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                '}';
    }
}
