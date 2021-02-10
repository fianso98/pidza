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
@Table(name = "pizza_list" )
public class PizzaList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pizza_id")
    private int pizza_id;
    @Column(name = "pizza_type")
    private String pizza_type;
    @Column(name = "pizza_photo")
    private String pizza_photo;
    @Column(name = "pizza_prix")
    private Float pizza_prix; 
    
    @ManyToMany(mappedBy = "pizzaLists")
    List<Magasin> magasins;

    public int getPizza_id() {
        return pizza_id;
    }
    public String getPizza_photo() {
        return pizza_photo;
    }
    public Float getPizza_prix() {
        return pizza_prix;
    }
    public String getPizza_type() {
        return pizza_type;
    }
    public void setPizza_id(int pizza_id) {
        this.pizza_id = pizza_id;
    }
    public void setPizza_photo(String pizza_photo) {
        this.pizza_photo = pizza_photo;
    }
    public void setPizza_prix(Float pizza_prix) {
        this.pizza_prix = pizza_prix;
    }
    public void setPizza_type(String pizza_type) {
        this.pizza_type = pizza_type;
    }
}
