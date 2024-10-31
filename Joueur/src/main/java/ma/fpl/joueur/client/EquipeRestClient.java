package ma.fpl.joueur.client;

import ma.fpl.joueur.module.Equipe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Equipe",url = "http://localhost:8881/api/v1/equip")
public interface EquipeRestClient {
    @GetMapping("/{id}")
    Equipe getEquipeById(@PathVariable Long id);
}
