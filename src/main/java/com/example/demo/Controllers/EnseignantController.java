package com.example.demo.Controllers;

import com.example.demo.Entities.Enseignant;
import com.example.demo.Services.EnseignantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enseignant")
@RequiredArgsConstructor
public class EnseignantController {
    private final EnseignantService enseignantService;
    @PostMapping("/enregistrer")
    public ResponseEntity<?> enregistrer(@RequestBody Enseignant enseignant){
        try{
            Enseignant e=enseignantService.enregistrer(enseignant);
            return ResponseEntity.ok("l'enseignant a été enregistrer avec succes");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erreur lors de la creation de l'enseignant");
        }
    }
    @PutMapping("/modifier")
    public ResponseEntity< ?> modifierEnseignant(@RequestBody Enseignant enseignant) throws Exception {
        try {
            Enseignant updatedEnseignant = enseignantService.modifier(enseignant);
            return ResponseEntity.ok("l'enseignant a été modifier avec succes");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erreur lors de la modification de l'enseignant");

        }
    }
    @DeleteMapping("/supprimer/{matricule}")
    public ResponseEntity<String> supprimerEnseignant(@PathVariable Long matricule) throws Exception {
        enseignantService.supprimer(matricule);
        return new ResponseEntity<>("Enseignant supprimé avec succès", HttpStatus.OK);
    }
    @GetMapping("/rechercher/{matricule}")
    public ResponseEntity<Enseignant> rechercherEnseignant(@PathVariable Long matricule) throws Exception {
        Enseignant enseignant = enseignantService.rechercher(matricule);
        return new ResponseEntity<>(enseignant, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Enseignant>> listDesEnseignants() {
        List<Enseignant> enseignants = enseignantService.listDesEnseignants();
        return new ResponseEntity<>(enseignants, HttpStatus.OK);
    }
}
