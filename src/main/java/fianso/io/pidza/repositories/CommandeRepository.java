package fianso.io.pidza.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fianso.io.pidza.models.Commande;

public interface CommandeRepository extends CrudRepository<Commande , Integer> {
    @Query(value = "SELECT * FROM commande c, magasin m  WHERE c.magasin_id= m.magasin_id and m.responsable_id = ?1", 
    nativeQuery = true)
    List<Commande> findByResponsable(int responsable);
}
