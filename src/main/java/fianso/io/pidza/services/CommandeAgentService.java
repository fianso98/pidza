package fianso.io.pidza.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.CommandeAgent;
import fianso.io.pidza.repositories.CommandeAgentRepository;

@Service
public class CommandeAgentService {
    @Autowired
    private CommandeAgentRepository commandeAgentRepository;

    public void addCommandeAgent(CommandeAgent commandeAgent){
        commandeAgentRepository.save(commandeAgent);
    }
}
