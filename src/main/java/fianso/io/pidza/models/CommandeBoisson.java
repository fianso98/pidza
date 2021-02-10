package fianso.io.pidza.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class CommandeBoisson {
    @EmbeddedId
    CommandeBoissonKey id = new CommandeBoissonKey();

    @ManyToOne
    @MapsId("commandeIdBoisson")
    @JoinColumn(name = "commande_id")
    Commande commandes_boisson;

    @ManyToOne
    @MapsId("boissonId")
    @JoinColumn(name = "boisson_id")
    Boisson boissons;

    @Column(name = "nombre_boisson")
    int nombre_boisson;

    
    public void setId(CommandeBoissonKey id) {
        this.id = id;
    }   
    public int getNombre_boisson() {
        return nombre_boisson;
    }
    public Boisson getBoissons() {
        return boissons;
    }
    public void setBoissons(Boisson boissons) {
        this.boissons = boissons;
    }
    public void setNombre_boisson(int nombre_boisson) {
        this.nombre_boisson = nombre_boisson;
    }
    public void setCommandes_boisson(Commande commandes_boisson) {
        this.commandes_boisson = commandes_boisson;
    }
}
