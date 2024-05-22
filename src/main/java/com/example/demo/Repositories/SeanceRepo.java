package com.example.demo.Repositories;

import com.example.demo.Entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeanceRepo extends JpaRepository<Seance,Long> {
    List<Seance> findAllByClasseIgnoreCaseAndMatiereIgnoreCase(String classe, String matiere);

    List<Seance> findAllByClasse(String classe);
}
