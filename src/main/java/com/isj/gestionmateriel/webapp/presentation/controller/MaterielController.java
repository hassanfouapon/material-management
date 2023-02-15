package com.isj.gestionmateriel.webapp.presentation.controller;
import com.isj.gestionmateriel.webapp.model.entities.dto.MaterielDTO;
import com.isj.gestionmateriel.webapp.service.IMateriel;
import com.isj.gestionmateriel.webapp.service.MaterielImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MaterielController {

    @Autowired
    IMateriel Imateriel;
    @GetMapping("/hassanlisteMoiLesMateriels")
    public String listerMateriels( Model model) {
       //appel de la couche service pour avoir la liste des materiels
        List<MaterielDTO> materielDTOS= Imateriel.listermateriel();

        model.addAttribute("materielDTOS",materielDTOS);

        return "listeMateriels";
    }
    @GetMapping("/home")
    public String afficherIndex(Model mode){
        return "index";
    }

//affichage du formulaire
    @GetMapping("/ajoutematerielform")
    public String ajouterMaterielForm( Model model) {
        MaterielDTO materielDTO= new MaterielDTO();
        materielDTO.setReference("ref");
        materielDTO.setDateAcquisition("date");
        materielDTO.setNom("nom");
        model.addAttribute("materielDTO",materielDTO);


        //appel de la couche service pour avoir la liste des materiels

        return "ajouter";
    }
    //Traiment des valeurs saisies dans le formulaire
    @PostMapping("/enregistrerMateriel")
    public String enregistrerMateriel(@ModelAttribute MaterielDTO materielDTO, Model model){
        //appel de la couche service injectée pour enregistrer un materiel
        Imateriel.ajouterMateriel(materielDTO);
        return "redirect:hassanlisteMoiLesMateriels";
    }

    // afficher le formulire de modification
    @GetMapping("/update_materiel")
    public String getUpdateView(@RequestParam(name = "refmateriel") String refmateriel, Model model){
        // appel de la methode de la couche service qui retourne un materiel en fonction de son ID
        MaterielDTO materielDTO = Imateriel.detailMateriel(refmateriel);
        // ob jet materiel en fonction de son id
        model.addAttribute("materielDTO", materielDTO);
        return "update";

    }

    @GetMapping("/recherchematerielform")
    public String rechercherMaterielForm(@RequestParam(value = "q", defaultValue = "") String q, Model model){

        //appel de la couche service pour avoir la liste des materiels
        List<MaterielDTO> materielDTOS= Imateriel.rechercherMateriels(q);
        model.addAttribute("materielDTOS", materielDTOS);
        return "rechercher";
    }


    @GetMapping("/detailmateriel")
    public String detailMateriel(@RequestParam(name="refmateriel") String refmateriel, Model model) {

        //appel de la methode de la couche service qui retourne
       // System.out.println(refmateriel);
        MaterielDTO materielDTO= Imateriel.detailMateriel(refmateriel);
        // un objet materiel en fonction de son id
        model.addAttribute("materielDTO", materielDTO);
        return "detail";
    }
    @GetMapping("/supprimer")
        public String deleteMateriel(@RequestParam(name = "refmateriel") String refmateriel){
        Imateriel.supprimerMateriel(refmateriel);
            return "redirect/liste materiel";
        }


}
