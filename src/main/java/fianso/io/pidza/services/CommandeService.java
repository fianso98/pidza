package fianso.io.pidza.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.Commande;
import fianso.io.pidza.models.CommandePizza;
import fianso.io.pidza.repositories.CommandePizzaRepository;
import fianso.io.pidza.repositories.CommandeRepository;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CommandePizzaRepository commandePizzaRepository;

    
    public List<Commande> getAllCommandes(){
        List<Commande> ls = new ArrayList<>();
        commandeRepository.findAll().forEach(ls::add);
        return ls ;
    }
    
    public Optional<Commande> getCommandesById(int id){
        Optional<Commande> ls = commandeRepository.findById(id);
        if(ls.isPresent())
        return ls;
        return null;

    }
    
    public void addCommande(Commande commande){
        commandeRepository.save(commande);
    }
    public void updateCommande(Commande commande){
        commandeRepository.save(commande);
        
            
    }
    public void deleteCommande(int id){
        commandeRepository.deleteById(id);
    }

    public List<Commande> getCommandeByResponsable(int id){
        return commandeRepository.findByResponsable(id);
    }
}
