package com.example.demo.Services;

import com.example.demo.Entities.*;
import com.example.demo.Repositories.EnseignantRepo;
import com.example.demo.Repositories.SeanceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeanceService {
    private final SeanceRepo seanceRepo;
    private final EnseignantRepo enseignantRepo;
    public Seance enregistrer(seanceRequest seance) throws Exception {
        Optional<Enseignant> enseignant = enseignantRepo.findByMatricule(seance.getMatricule());
        if (enseignant.isPresent()) {
            var s = Seance.builder()
                    .jour(Jour.valueOf(seance.getJour().toUpperCase()))
                    .classe(seance.getClasse().toLowerCase())
                    .heureFin(seance.getHeureFin())
                    .heureDebut(seance.getHeureDebut())
                    .matiere(seance.getMatiere().toUpperCase())
                    .enseignant(enseignant.get())
                    .build();
            return seanceRepo.save(s);
        }
        throw new Exception("Enseignant avec a mtricule "+seance.getMatricule()+" n'existe pas");
    }
    public List<seanceResponse> listeDesSeances(){
        var seances= seanceRepo.findAll();
        List<seanceResponse> resSeance= new ArrayList<>();
        for(Seance seance:seances){
            var s=seanceResponse.builder()
                    .nom(seance.getEnseignant().getNom())
                    .contact(seance.getEnseignant().getContact())
                    .id(seance.getId())
                    .heureDebut(seance.getHeureDebut())
                    .heureFin(seance.getHeureFin())
                    .jour(seance.getJour())
                    .matiere(seance.getMatiere())
                    .classe(seance.getClasse())
                    .build();
            resSeance.add(s);

        }
        return resSeance;
    }
    public List<seanceResponse> liste(String classe, String matiere) {
        var seances = seanceRepo.findAllByClasseIgnoreCaseAndMatiereIgnoreCase(classe, matiere);
        System.out.println("Retrieved seances: " + seances); // Add logging

        List<seanceResponse> resSeance = new ArrayList<>();
        for (Seance seance : seances) {
            var s = seanceResponse.builder()
                    .nom(seance.getEnseignant().getNom())
                    .contact(seance.getEnseignant().getContact())
                    .id(seance.getId())
                    .heureDebut(seance.getHeureDebut())
                    .heureFin(seance.getHeureFin())
                    .jour(seance.getJour())
                    .matiere(seance.getMatiere())
                    .classe(seance.getClasse())
                    .build();
            resSeance.add(s);
        }
        return resSeance;
    }

    public void supprimer(Long id) throws Exception {
        Optional<Seance> seance=seanceRepo.findById(id);
        if(seance.isPresent()){
            seanceRepo.deleteById(id);
        }
        else{throw new Exception("la seance avec id "+ id+" n'existe pas ");}
    }
    public List<seanceResponse> emploi(String classe){
        var seances= seanceRepo.findAllByClasse(classe);
        List<seanceResponse> resSeance= new ArrayList<>();
        for(Seance seance:seances){
            var s=seanceResponse.builder()
                    .nom(seance.getEnseignant().getNom())
                    .contact(seance.getEnseignant().getContact())
                    .id(seance.getId())
                    .heureDebut(seance.getHeureDebut())
                    .heureFin(seance.getHeureFin())
                    .jour(seance.getJour())
                    .matiere(seance.getMatiere())
                    .classe(seance.getClasse())
                    .build();
            resSeance.add(s);

        }
        return resSeance;
    }

}
