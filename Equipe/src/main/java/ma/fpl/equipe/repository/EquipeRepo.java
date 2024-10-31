package ma.fpl.equipe.repository;

import ma.fpl.equipe.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepo extends JpaRepository<Equipe,Long> {
}
