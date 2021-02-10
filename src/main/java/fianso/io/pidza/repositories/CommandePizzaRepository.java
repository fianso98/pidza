package fianso.io.pidza.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fianso.io.pidza.models.CommandePizza;
import fianso.io.pidza.models.CommandePizzaKey;

public interface CommandePizzaRepository extends CrudRepository<CommandePizza,CommandePizzaKey> {
    
}
