package fianso.io.pidza.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.CommandeClient;
import fianso.io.pidza.repositories.CommandeClientRepository;

@Service
public class CommandeClientService {
    
    @Autowired
    private CommandeClientRepository commandeClientRepository;

    public void addCommandeClient(CommandeClient commandeClient){
        commandeClientRepository.save(commandeClient);
    }
}
