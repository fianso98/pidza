package fianso.io.pidza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.Ingrediant;
import fianso.io.pidza.repositories.IngrediantRepository;

@Service
public class IngrediantService {
    
    @Autowired
    private IngrediantRepository ingrediantRepository;

    public List<Ingrediant> getAllIngrediants(){
        List<Ingrediant> ls = new ArrayList<>();
        ingrediantRepository.findAll().forEach(ls::add);
        return ls;
    }
    public void addIngrediant(Ingrediant ingrediant){
        ingrediantRepository.save(ingrediant);
    }
}
