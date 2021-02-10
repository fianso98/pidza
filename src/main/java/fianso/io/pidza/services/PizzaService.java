package fianso.io.pidza.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.Pizza;
import fianso.io.pidza.repositories.PizzaRepository;

@Service
public class PizzaService {
    
    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizzas(){
        List<Pizza> ls = new ArrayList<>();
        pizzaRepository.findAll().forEach(ls::add);
        return ls;
    }
    public Optional<Pizza> getPizzaById(int id){
        Optional<Pizza> ls = pizzaRepository.findById(id);
        if ( ls.isPresent())
        return ls;
        return null;
    }
    public void addPizza(Pizza pizza){
        pizzaRepository.save(pizza);
    }
    public void updatePizza(Pizza pizza){
        pizzaRepository.save(pizza);
    }
    
    public void deletePizzaById(int id ){
        pizzaRepository.deleteById(id);
    }
}
