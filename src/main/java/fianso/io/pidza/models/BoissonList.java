package fianso.io.pidza.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "boisson_list" )
public class BoissonList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "boisson_id")
    private int boisson_id;
    @Column(name = "boisson_nom")
    private String boisson_nom;
    @Column(name = "boisson_photo")
    private String boisson_photo;
    @Column(name = "boisson_prix")
    private Float boisson_prix; 

    @ManyToMany(mappedBy = "boissonLists")
    List<Magasin> magasins;
    public int getBoisson_id() {
        return boisson_id;
    }
    public String getBoisson_nom() {
        return boisson_nom;
    }
    public String getBoisson_photo() {
        return boisson_photo;
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
    public void setBoisson_photo(String boisson_photo) {
        this.boisson_photo = boisson_photo;
    }
    public void setBoisson_prix(Float boisson_prix) {
        this.boisson_prix = boisson_prix;
    }
}


    
    
    