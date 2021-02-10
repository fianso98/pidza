package fianso.io.pidza.repositories;

import org.springframework.data.repository.CrudRepository;

import fianso.io.pidza.models.Client;

public interface ClientRepository extends CrudRepository<Client , Integer> {
    
}
