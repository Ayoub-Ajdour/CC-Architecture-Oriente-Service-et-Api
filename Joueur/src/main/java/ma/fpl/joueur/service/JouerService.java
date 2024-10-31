package ma.fpl.joueur.service;


import ma.fpl.joueur.client.EquipeRestClient;
import ma.fpl.joueur.entity.Joueur;
import ma.fpl.joueur.module.Equipe;
import ma.fpl.joueur.repository.JoueurRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JouerService {
    private JoueurRepo joueurRepo;
    private EquipeRestClient equipeRestClient;

    public JouerService(JoueurRepo joueurRepo, EquipeRestClient equipeRestClient) {
        this.joueurRepo = joueurRepo;
        this.equipeRestClient = equipeRestClient;
    }
    public List<Joueur> getAlldesc(){
        List<Joueur> joueurList=joueurRepo.getAllByDesc();
        for(Joueur joueur:joueurList){
            joueur.setEquipe(equipeRestClient.getEquipeById(joueur.getIdEquipe()));
        }
        return joueurList;
    }
    public Joueur addJoueur(Joueur joueur){
        joueur.setEquipe(equipeRestClient.getEquipeById(joueur.getIdEquipe()));
        return  joueurRepo.save(joueur);
    }
    public Joueur getJoueurById(Long id){
        Joueur joueur=joueurRepo.findById(id).get();
       joueur.setEquipe(equipeRestClient.getEquipeById(joueur.getIdEquipe()));
       return joueur;
    }
    public void deleteJoueur(Long id){
        joueurRepo.deleteById(id);
    }
    public Joueur update(Long id,Joueur joueur){
        Joueur joueur1=joueurRepo.getById(id);
        joueur1.setName(joueur.getName());
        joueur1.setSalaire(joueur.getSalaire());
        joueur1.setButMarque(joueur.getButMarque());
        joueur1.setPosition(joueur.getPosition());
        joueur1.setEquipe(equipeRestClient.getEquipeById(joueur.getIdEquipe()));
        joueur1.setIdEquipe(joueur.getIdEquipe());
        return joueur1;
    }
    public Joueur MarqueBut(Long id,int nbrBut){
        Joueur joueur1=joueurRepo.getById(id);
        joueur1.setButMarque(joueur1.getButMarque()+nbrBut);
        return joueurRepo.save(joueur1);
    }
    public int getAllBut(){
        return joueurRepo.getAllBut();
    }
    public Joueur MeilleurButeur(){
        return joueurRepo.MeilleurButeur();
    }


}
