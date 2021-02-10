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
@Table(name = "ingrediant")
public class Ingrediant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingrediant_id")
    private int ingrediant_id;
    @Column(name = "ingrediant_nom")
    private String ingrediant_nom;
    @Column(name = "ingrediant_prix")
    private Float ingrediant_prix; 

    @ManyToMany(mappedBy = "ingrediants")
    List<Pizza> pizzas;

    public int getIngrediant_id() {
        return ingrediant_id;
    }
    public String getIngrediant_nom() {
        return ingrediant_nom;
    }
    public Float getIngrediant_prix() {
        return ingrediant_prix;
    }
    public void setIngrediant_id(int ingrediant_id) {
        this.ingrediant_id = ingrediant_id;
    }
    public void setIngrediant_nom(String ingrediant_nom) {
        this.ingrediant_nom = ingrediant_nom;
    }
    public void setIngrediant_prix(Float ingrediant_prix) {
        this.ingrediant_prix = ingrediant_prix;
    }

}
