package com.isj.gestionmateriel.webapp.service;

import com.isj.gestionmateriel.webapp.model.entities.dto.MaterielDTO;

import java.util.List;

public interface IMateriel {
    int ajouterMateriel(MaterielDTO materielDTO);
    int supprimerMateriel(String reference);
    int modifiermateriel(MaterielDTO materielDTO);
    List<MaterielDTO> listermateriel();
    MaterielDTO detailMateriel(String reference);
    List<MaterielDTO> rechercherMateriels(String motcle);
    int nombreTotalMatreriels();
}
