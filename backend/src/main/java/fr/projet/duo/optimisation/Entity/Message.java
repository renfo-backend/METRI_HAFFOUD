package fr.projet.duo.optimisation.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String date_send;

    @ManyToOne
    @JoinColumn(name = "party_id")
    @ToString.Exclude
    private Party party;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @ToString.Exclude
    private Users users;

    // Getters and Setters
}
