package fianso.io.pidza.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fianso.io.pidza.models.Commande;
import fianso.io.pidza.services.CommandeService;

@RestController
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping(value = "commandes")
    public List<Commande> getAllCommandes(){
        return commandeService.getAllCommandes();
    }
    @GetMapping(value = "commandes/{id}")
    public Optional<Commande> getCommandesById(@PathVariable int id ){
        return commandeService.getCommandesById(id);
    }
    @PostMapping(value = "commandes/add")
    public void addCommande(@RequestBody Commande commande){
        commandeService.addCommande(commande);
       
    }
    @PutMapping(value = "commandes/update")
    public void updateCommande(@RequestBody Commande commande){
        commandeService.updateCommande(commande);
    }
    @DeleteMapping(value = "commandes/delete/{id}")
    public void deleteCommande(@PathVariable int id){
        commandeService.deleteCommande(id);
    }
}
