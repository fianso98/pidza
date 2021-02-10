package fianso.io.pidza.models;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pizza_id")
    private int pizza_id;
    @Column(name = "pizza_type")
    private String pizza_type;
    @Column(name = "pizza_prix")
    private Float pizza_prix; 



    @ManyToMany
    @JoinTable( name = "pizza_ingrediant", 
                joinColumns = @JoinColumn(name = "pizza_id"), 
                inverseJoinColumns = @JoinColumn(name = "ingrediant_id"))
    List<Ingrediant> ingrediants;


    @OneToMany(mappedBy = "pizzas" ,cascade = CascadeType.ALL)
    List<CommandePizza> nbrPizzas;

    
    public Integer getPizza_id() {
        return pizza_id;
    }
    public String getPizza_type() {
        return pizza_type;
    }
    
    public Float getPizza_prix() {
        return pizza_prix;
    }
    public List<Ingrediant> getIngrediants() {
        return ingrediants;
    }
    public void setPizza_id(int pizza_id) {
        this.pizza_id = pizza_id;
    }
    public void setPizza_type(String pizza_type) {
        this.pizza_type = pizza_type;
    }
   
    public void setPizza_prix(Float pizza_prix) {
        this.pizza_prix = pizza_prix;
    }
    public void setIngrediants(List<Ingrediant> ingrediants) {
        this.ingrediants = ingrediants;
    }
    
}
