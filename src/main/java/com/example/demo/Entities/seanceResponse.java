package com.example.demo.Entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class seanceResponse {
    private Long id;
    private String classe;
    private String matiere;
    private Jour jour;
    private String heureDebut;
    private String heureFin;
    private  String nom;
    private String contact;
}
