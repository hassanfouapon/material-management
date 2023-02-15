package com.isj.gestionmateriel.webapp.model.entities;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Materiel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String reference;
    private String nom;
    private String date;
    private String dateAcquisition;
    private String etat;
    private String description;


}

