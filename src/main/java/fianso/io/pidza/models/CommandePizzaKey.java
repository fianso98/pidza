package fianso.io.pidza.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CommandePizzaKey implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "commande_id")
    int commandeIdPizza;

    @Column(name = "pizza_id")
    int pizzaId;

    public int getCommandeIdPizza() {
        return commandeIdPizza;
    }
    public int getPizza_id() {
        return pizzaId;
    }
    public void setCommandeIdPizza(int commandeIdPizza) {
        this.commandeIdPizza = commandeIdPizza;
    }
    public void setPizza_id(int pizzaId) {
        this.pizzaId = pizzaId;
    }
    // hashcode and equals implementation
}
