package com.isj.gestionmateriel.webapp.model.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterielDTO {
    private String reference;
    private String nom;
    private String date;
    private String dateAcquisition;
    private String etat;
    private String description;


}
