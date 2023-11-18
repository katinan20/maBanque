package com.paulo.pauloBanque.controller;

import com.paulo.pauloBanque.entity.Compte;
import com.paulo.pauloBanque.entity.Operation;
import com.paulo.pauloBanque.mettier.BanqueMettier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BanqueController {
    @Autowired
    private BanqueMettier banqueMettier;

    @RequestMapping("/operation")
    public String index(){
        return"compte";
    }

/*
    @RequestMapping("/accueil")
    public String accueil(){
        return "Template";
    }*/

    @RequestMapping("/consulterCompte")
    public String ConsulterCompte(Model model, String codeCompte,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "4") int size){
        try{
            Compte cp = banqueMettier.consulteCompte(codeCompte);
            Page<Operation> pageOperation =banqueMettier.listeOperation(codeCompte,page,size);
            model.addAttribute("listeOperation", pageOperation.getContent());
            model.addAttribute("pageCourant", page);
            model.addAttribute("compte", cp);
            model.addAttribute("codeCompte", codeCompte);
        }catch (Exception e){
            model.addAttribute("exception",e);
        }
        return "compte";
    }


    @RequestMapping(value="/saveOperation",method=RequestMethod.POST)
    public String saveOperation(Model model, String typeOperation, String codeCompte, double montant, String CodeCompte2){
        try {
            if (typeOperation.equals("VERS")) {
                banqueMettier.verser(codeCompte, montant);
            } else if (typeOperation.equals("RET")) {
                banqueMettier.retirer(codeCompte, montant);
            } else {
                banqueMettier.virement(codeCompte, CodeCompte2, montant);
            }
        }catch (Exception e){
            model.addAttribute("error",e);
           return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
        }
       // return "Compte";
        return "redirect:/consulterCompte?codeCompte="+codeCompte;
    }

}
