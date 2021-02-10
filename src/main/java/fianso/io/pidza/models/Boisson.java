package fianso.io.pidza.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "boisson")
public class Boisson {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "boisson_id")
    private int boisson_id;
    @Column(name = "boisson_nom")
    private String boisson_nom;
    @Column(name = "boisson_prix")
    private Float boisson_prix; 

    @OneToMany(mappedBy = "boissons")
    List<CommandeBoisson> nbrBoissons;

   
    public Integer getBoisson_id() {
        return boisson_id;
    }
    public String getBoisson_nom() {
        return boisson_nom;
    }
    
    public Float getBoisson_prix() {
        return boisson_prix;
    }
    
    public void setBoisson_id(int boisson_id) {
        this.boisson_id = boisson_id;
    }
    public void setBoisson_nom(String boisson_nom) {
        this.boisson_nom = boisson_nom;
    }
   
    public void setBoisson_prix(Float boisson_prix) {
        this.boisson_prix = boisson_prix;
    }


}
