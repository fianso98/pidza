package fianso.io.pidza.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "commande_pizza")
public class CommandePizza {


    @EmbeddedId
    CommandePizzaKey id = new CommandePizzaKey();

    @ManyToOne
    @MapsId("commandeIdPizza")
    @JoinColumn(name = "commande_id" , nullable = false)
    Commande commandes_pizza;

    @ManyToOne
    @MapsId("pizzaId")
    @JoinColumn(name = "pizza_id" , nullable = false)
    Pizza pizzas;

    @Column(name = "nombre_pizza")
    int nombre_pizza;

    
  
   public void setId(CommandePizzaKey id) {
       this.id = id;
   }
   
    public Pizza getPizzas() {
        return pizzas;
    }
    
    public void setPizzas(Pizza pizzas) {
        this.pizzas = pizzas;
    }
    public void setNombre_pizza(int nombre_pizza) {
        this.nombre_pizza = nombre_pizza;
    }
    public int getNombre_pizza() {
        return nombre_pizza;
    }
   public void setCommandes_pizza(Commande commandes_pizza) {
       this.commandes_pizza = commandes_pizza;
   }
}
