package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String classe;
    private String matiere;
    @Enumerated(EnumType.STRING)
    private Jour jour;
    private String heureDebut;
    private String heureFin;
    @ManyToOne
    @JoinColumn(name = "matricule" ,referencedColumnName = "matricule")
    private  Enseignant enseignant;
}
