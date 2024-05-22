package com.example.demo.Entities;


import lombok.Data;

import java.time.LocalTime;
@Data
public class seanceRequest {
    private String classe;
    private String matiere;
    private String jour;
    private String heureDebut;
    private String heureFin;
    private  Long matricule;
}
