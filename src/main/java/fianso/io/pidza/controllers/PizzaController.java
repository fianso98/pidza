package fianso.io.pidza.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fianso.io.pidza.models.Pizza;
import fianso.io.pidza.services.PizzaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PizzaController {
    
    @Autowired
    private PizzaService pizzaService;

    @GetMapping( value = "pizzas")
    public List<Pizza> getAllPizzas(){
        return pizzaService.getAllPizzas();
    }
    @GetMapping(value = "pizzas/{id}")
    public Optional<Pizza> getPizzaById(@PathVariable int id){
        return pizzaService.getPizzaById(id);
    }

    
    @PostMapping(value="pizzas/add")
    public void addPizza(@RequestBody Pizza pizza) {
        pizzaService.addPizza(pizza);
    }
    @PutMapping (value="pizzas/update")
    public void updatePizza(@RequestBody Pizza pizza) {
        pizzaService.updatePizza(pizza);
    }
    //not neccesary cause we need some record of pizza (only if we inserted a wrong data and still we can update it)
    @DeleteMapping ( value = "pizzas/delete/{id}")
    public void deletePizzaById(@PathVariable int id){
        pizzaService.deletePizzaById(id);
    }
    
}
