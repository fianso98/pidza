package fianso.io.pidza.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fianso.io.pidza.models.Magasin;
public interface MagasinRepository extends CrudRepository<Magasin,Integer>{
   
    @Query(value = "SELECT * FROM magasin m WHERE m.magasin_wilaya = ?1", 
    nativeQuery = true)
    List<Magasin> findByAddress(String adress);
}
