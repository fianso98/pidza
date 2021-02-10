package fianso.io.pidza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fianso.io.pidza.models.Ingrediant;
import fianso.io.pidza.services.IngrediantService;

@RestController
public class IngrediantController {
    
    @Autowired
    private IngrediantService ingrediantService;


    @GetMapping( value =  "ingrediants")
    public List<Ingrediant> getAllIngrediants(){
        return ingrediantService.getAllIngrediants();
    }
}
