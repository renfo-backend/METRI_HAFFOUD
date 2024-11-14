package fr.projet.optmisationDb.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "interest")
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "interests")
    private List<Users> users;

}
