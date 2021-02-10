package fianso.io.pidza.repositories;

import org.springframework.data.repository.CrudRepository;

import fianso.io.pidza.models.CommandeBoisson;
import fianso.io.pidza.models.CommandeBoissonKey;

public interface CommandeBoissonRepository extends CrudRepository<CommandeBoisson,CommandeBoissonKey> {
    
}
