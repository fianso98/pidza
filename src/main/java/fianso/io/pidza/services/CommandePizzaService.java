package fianso.io.pidza.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.CommandePizza;
import fianso.io.pidza.repositories.CommandePizzaRepository;

@Service
public class CommandePizzaService {
    
    @Autowired
    private CommandePizzaRepository commandePizzaRepository;

    public void addCommandePizza(CommandePizza commandePizza){
        commandePizzaRepository.save(commandePizza);
    }

}
