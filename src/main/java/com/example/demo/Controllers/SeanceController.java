package com.example.demo.Controllers;

import com.example.demo.Entities.Seance;
import com.example.demo.Entities.seanceRequest;
import com.example.demo.Entities.seanceResponse;
import com.example.demo.Services.SeanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SeanceController {
    private final SeanceService seanceService;

    @PostMapping("/seance/enregistrer")
    public ResponseEntity<Seance> enregistrerSeance(@RequestBody seanceRequest seance) {
        try {
            Seance savedSeance = seanceService.enregistrer(seance);
            return ResponseEntity.ok(savedSeance);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/seance/liste")
    public ResponseEntity<List<?>> listeDesSeances() {
        List<seanceResponse> seances = seanceService.listeDesSeances();
        return ResponseEntity.ok(seances);
    }

    @GetMapping("/seance/liste/{classe}/{matiere}")
    public ResponseEntity<List<?>> listeParClasseEtMatiere(@PathVariable String classe, @PathVariable String matiere) {
        List<seanceResponse> seances = seanceService.liste(classe, matiere);
        return ResponseEntity.ok(seances);
    }

    @DeleteMapping("/seance/supprimer/{id}")
    public ResponseEntity<String> supprimerSeance(@PathVariable Long id) {
        try {
            seanceService.supprimer(id);
            return ResponseEntity.ok("La séance avec l'ID " + id + " a été supprimée avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La séance avec l'ID " + id + " n'existe pas.");
        }
    }

    @GetMapping("/emploi/{classe}")
    public ResponseEntity<List<?>> emploiDuTemps(@PathVariable String classe) {
        List<seanceResponse> emploi = seanceService.emploi(classe);
        return ResponseEntity.ok(emploi);
    }

}
