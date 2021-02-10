package fianso.io.pidza.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.CommandeBoisson;
import fianso.io.pidza.repositories.CommandeBoissonRepository;

@Service
public class CommandeBoissonService {
    

    @Autowired
    private CommandeBoissonRepository commandeBoissonRepository;

    public void addCommandeBoisson(CommandeBoisson commandeBoisson){
        commandeBoissonRepository.save(commandeBoisson);
    }
}
