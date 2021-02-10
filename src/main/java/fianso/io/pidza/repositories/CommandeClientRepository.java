package fianso.io.pidza.repositories;

import org.springframework.data.repository.CrudRepository;

import fianso.io.pidza.models.CommandeClient;
import fianso.io.pidza.models.CommandeClientKey;

public interface CommandeClientRepository extends CrudRepository<CommandeClient,CommandeClientKey>{
    
}
