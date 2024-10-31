package ma.fpl.equipe.controller;

import ma.fpl.equipe.entity.Equipe;
import ma.fpl.equipe.service.EquipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equip")
public class EquipeController {
    private EquipeService equipeService;

    public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }
    @GetMapping
    public ResponseEntity<List<Equipe>> getAll(){
        return ResponseEntity.ok(equipeService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getById(@PathVariable Long id){
        return ResponseEntity.ok(equipeService.getById(id));
    }
}
