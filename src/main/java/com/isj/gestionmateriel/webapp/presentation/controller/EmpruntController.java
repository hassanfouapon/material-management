package com.isj.gestionmateriel.webapp.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpruntController {
    @GetMapping("/hassanlisteMoiLesMaterielsEmpruntes")
    public String listerEmprunts( Model model) {
        //appel de la couche service pour avoir la liste des materiels
        return "listeEmprunt";
    }
}
