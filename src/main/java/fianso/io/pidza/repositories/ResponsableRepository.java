package fianso.io.pidza.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import fianso.io.pidza.models.Responsable;
public interface ResponsableRepository extends CrudRepository<Responsable,Integer>{
    
    @Query(value = "SELECT * FROM responsable c WHERE c.responsable_username = ?1", 
    nativeQuery = true)
    Optional<Responsable> findByUsername(String username);
}