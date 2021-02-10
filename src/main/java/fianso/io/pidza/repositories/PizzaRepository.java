package fianso.io.pidza.repositories;

import org.springframework.data.repository.CrudRepository;

import fianso.io.pidza.models.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza ,Integer> {
    
}
