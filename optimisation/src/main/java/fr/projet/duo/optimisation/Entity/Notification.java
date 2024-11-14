package fr.projet.duo.optimisation.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private boolean isRead;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "users_id")
    @ToString.Exclude
    private Users users;



    // Getters and Setters
}