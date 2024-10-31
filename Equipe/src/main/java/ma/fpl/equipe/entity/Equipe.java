package ma.fpl.equipe.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter @Getter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Equipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipe;
    private String Code;
    private String Libelle;
}
