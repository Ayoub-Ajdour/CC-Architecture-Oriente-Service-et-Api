package ma.fpl.joueur.repository;

import ma.fpl.joueur.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoueurRepo extends JpaRepository<Joueur, Long> {
    @Query("select jr from Joueur jr order by jr.ButMarque desc")
    List<Joueur> getAllByDesc();
    @Query("select sum(jr.ButMarque) from Joueur jr")
    int getAllBut();
    @Query("select jr from Joueur jr order by jr.ButMarque desc limit 1")
    Joueur MeilleurButeur();
}
