package ma.fpl.equipe.service;


import ma.fpl.equipe.entity.Equipe;

import ma.fpl.equipe.repository.EquipeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {
    private EquipeRepo equipeRepo;
//    private JoueurRestClient joueurRestClient;

    public EquipeService(EquipeRepo equipeRepo) {
        this.equipeRepo = equipeRepo;
    }
    public List<Equipe> getAll(){
        return equipeRepo.findAll();
    }

    public Equipe getById(Long idEquipe){
        return equipeRepo.findById(idEquipe).get();
    }
}
