package com.example.demo.Services;

import com.example.demo.Entities.Enseignant;
import com.example.demo.Repositories.EnseignantRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnseignantService {
    private final EnseignantRepo enseignantRepo;
    public Enseignant enregistrer(Enseignant enseignant){
        Enseignant e=Enseignant.builder()
                .nom(enseignant.getNom())
                .Contact(enseignant.getContact())
                .build();
        return enseignantRepo.save(e);
    }
    public Enseignant modifier(Enseignant enseignant) throws Exception {
        Optional<Enseignant> e= enseignantRepo.findById(enseignant.getMatricule());
        if(e.isPresent()){
            return enseignantRepo.save(enseignant);
        }
        else{
            throw new Exception(" enseignant n'exist pas");
        }
    }
    public void supprimer(Long matricule) throws Exception {
        Optional<Enseignant> e= enseignantRepo.findById(matricule);
        if(e.isPresent()){
             enseignantRepo.delete(e.get());
        }
        else{
            throw new Exception(" enseignant n'exist pas");
        }
    }
    public Enseignant rechercher (Long matricule) throws Exception {
        Optional<Enseignant> e= enseignantRepo.findById(matricule);
        if(e.isPresent()){
            return e.get();
        }
        else{
            throw new Exception(" enseignant n'exist pas");
        }
    }
    public List<Enseignant> listDesEnseignants(){
        return enseignantRepo.findAll();
    }

}
