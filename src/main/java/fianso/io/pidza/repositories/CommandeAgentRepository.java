package fianso.io.pidza.repositories;

import org.springframework.data.repository.CrudRepository;

import fianso.io.pidza.models.CommandeAgent;
import fianso.io.pidza.models.CommandeAgentKey;

public interface CommandeAgentRepository extends CrudRepository<CommandeAgent,CommandeAgentKey>{
    
}
