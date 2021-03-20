package fianso.io.pidza.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fianso.io.pidza.models.Client;

public interface ClientRepository extends CrudRepository<Client , Integer> {
    
    @Query(value = "SELECT * FROM client c WHERE c.client_username = ?1", 
    nativeQuery = true)
    Optional<Client> findByUsername(String username);
}
