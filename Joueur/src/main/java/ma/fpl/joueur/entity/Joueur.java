package ma.fpl.joueur.entity;

import jakarta.persistence.*;
import lombok.*;
import ma.fpl.joueur.module.Equipe;

@Entity
@Builder
@Setter @Getter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Joueur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJoueur;
    private String name;
    private String position;
    private Double Salaire;
    private Long ButMarque;
    private Long idEquipe;
    @Transient
    private Equipe equipe;


}
