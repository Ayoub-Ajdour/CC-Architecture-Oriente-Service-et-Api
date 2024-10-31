package ma.fpl.joueur.module;

import jakarta.persistence.*;
import lombok.*;

@Setter @Getter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Equipe {
    private Long idEquipe;
    private String Code;
    private String Libelle;
}

