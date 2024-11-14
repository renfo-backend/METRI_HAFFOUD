package fr.projet.optmisationDb.DTO;

import fr.projet.optmisationDb.Entity.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class NotificationDTO {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)

    private Long id;
    private String message;
    private boolean isRead;


    private UsersDTO users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public UsersDTO getUsers() {
        return users;
    }

    public void setUsers(UsersDTO users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "NotificationDTO{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", isRead=" + isRead +
                ", users=" + users +
                '}';
    }
}
