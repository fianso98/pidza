package fianso.io.pidza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fianso.io.pidza.models.CommandePizza;
import fianso.io.pidza.services.CommandePizzaService;

@RestController
public class CommandePizzaController {
    
    @Autowired
    private CommandePizzaService commandePizzaService;

    @PostMapping( value = "commandes/pizza")
    public void addCommandePizza(@RequestBody CommandePizza commandePizza){

        commandePizzaService.addCommandePizza(commandePizza);
    }
}    
