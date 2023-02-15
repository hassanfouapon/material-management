package com.isj.gestionmateriel.webapp.service;

import com.isj.gestionmateriel.webapp.model.entities.Materiel;
import com.isj.gestionmateriel.webapp.model.entities.dto.MaterielDTO;
import com.isj.gestionmateriel.webapp.repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
public class MaterielImpl implements IMateriel {
    @Autowired
    private MaterielRepository materielRepository;
    @Override
    public int ajouterMateriel(MaterielDTO materielDTO) {
        Materiel materiel= new Materiel();
        materiel.setReference(materielDTO.getReference());
        materiel.setNom(materielDTO.getNom());
        materiel.setDate(materielDTO.getDate());
        materiel.setDateAcquisition(materielDTO.getDateAcquisition());
        materiel.setEtat(materielDTO.getEtat());
        materiel.setDescription(materielDTO.getDescription());

        return materielRepository.save(materiel).getId().intValue();

    }

    @Override
    public int supprimerMateriel(String reference) {

       Materiel materiel= materielRepository.findMaterielByReference(reference).get();
        materielRepository.deleteById(materiel.getId());
        return 1;

    }

    @Override
    public int modifiermateriel(MaterielDTO materielDTO) {
        //recherche materiel
        Materiel materiel= materielRepository.findMaterielByReference(materielDTO.getReference()).get();
        materiel.setNom(materielDTO.getNom());
        materiel.setEtat(materielDTO.getEtat());
        materiel.setDescription(materielDTO.getDescription());
        materiel.setDateAcquisition(materielDTO.getDateAcquisition());
        materielRepository.save(materiel);
        return materielRepository.save(materiel).getId().intValue();
    }

    @Override
    public List<MaterielDTO> listermateriel() {
        List<Materiel> materiels= materielRepository.findAll();
        return getMaterielDTOS(materiels);
    }

    @Override
    public MaterielDTO detailMateriel(String reference) {

        Materiel materiel= materielRepository.findMaterielByReference(reference).get();


        MaterielDTO materielDTO= new MaterielDTO();
        materielDTO.setReference(materiel.getReference());
        materielDTO.setNom(materiel.getNom());
        materielDTO.setEtat(materiel.getEtat());
        materielDTO.setDescription(materiel.getDescription());
        materielDTO.setDateAcquisition(materiel.getDateAcquisition());

        return materielDTO;
    }

    @Override
    public List<MaterielDTO> rechercherMateriels(String motcle) {

        List<Materiel> materiels= materielRepository.findMaterielByReferenceOrNomOrDescription(motcle, motcle,motcle);

        return getMaterielDTOS(materiels);
    }

    @Override
    public int nombreTotalMatreriels() {
        return materielRepository.findAll().size();
    }

    private List<MaterielDTO> getMaterielDTOS(List<Materiel> materiels) {
        List<MaterielDTO> materielDTOS= new ArrayList<MaterielDTO>();
        for (Materiel materiel: materiels){

            MaterielDTO materielDTO= new MaterielDTO();
            materielDTO.setReference(materiel.getReference());
            materielDTO.setNom(materiel.getNom());
            materielDTO.setEtat(materiel.getEtat());
            materielDTO.setDescription(materiel.getDescription());
            materielDTO.setDateAcquisition(materiel.getDateAcquisition());

            materielDTOS.add(materielDTO);
        }
        return materielDTOS;
    }
}
