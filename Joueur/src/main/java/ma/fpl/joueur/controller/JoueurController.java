package ma.fpl.joueur.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import ma.fpl.joueur.entity.Joueur;
import ma.fpl.joueur.service.JouerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/joueur")
public class JoueurController {
    private JouerService jouerService;
    public JoueurController(JouerService jouerService) {
        this.jouerService = jouerService;
    }
    @GetMapping
    public ResponseEntity<List<Joueur>> getAlldesc(){
        return ResponseEntity.ok(jouerService.getAlldesc());
    }
    @PostMapping("/nouveau")
    @Operation(summary = "Ajouter nouveau Joueur", description = "Ajouter un nouveau Joueur avec ID de son equipe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Joueur added"),
            @ApiResponse(responseCode = "400", description = "Invalid Joueur"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    public Joueur addJoueur(@RequestBody Joueur joueur) {
        return jouerService.addJoueur(joueur);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Joueur> getById(@PathVariable Long id){
        return ResponseEntity.ok(jouerService.getJoueurById(id));
    }
    @DeleteMapping("/{id}")
    public void deleteJoueur(@PathVariable Long id){
        jouerService.deleteJoueur(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Joueur> update(@PathVariable Long id,@RequestBody Joueur joueur){
        return ResponseEntity.ok(jouerService.update(id,joueur));
    }
    @PatchMapping("/{id}/{nbr}")
    public ResponseEntity<Joueur> marqueBut(@PathVariable Long id,@PathVariable int nbr){
        return ResponseEntity.ok(jouerService.MarqueBut(id,nbr));
    }

    @GetMapping("/meilleurButeur")
    public ResponseEntity<Joueur> MeilleurButeur(){
        return ResponseEntity.ok(jouerService.MeilleurButeur());
    }
    @GetMapping("/getAllBut")
    public ResponseEntity<Integer> getAllBut(){
        return ResponseEntity.ok(jouerService.getAllBut());
    }

}
