package com.example.demo.Repositories;

import com.example.demo.Entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnseignantRepo extends JpaRepository<Enseignant,Long> {
    Optional<Enseignant> findByMatricule(Long matricule);
}
