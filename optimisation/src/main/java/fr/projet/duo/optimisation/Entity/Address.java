package fr.projet.duo.optimisation.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;
    private String location;
    private String street;

    @OneToMany(mappedBy = "address")
    private List<Users> users = new ArrayList<>();

    @OneToMany(mappedBy = "address")
    private List<Party> parties = new ArrayList<>();
}
