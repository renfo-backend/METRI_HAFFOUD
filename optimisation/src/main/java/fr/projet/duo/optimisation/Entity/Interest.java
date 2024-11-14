package fr.projet.duo.optimisation.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;

@Entity
@Table(name = "interest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "interests")
    @JsonIgnore
    @ToStringExclude
    private List<Users> users;


}
