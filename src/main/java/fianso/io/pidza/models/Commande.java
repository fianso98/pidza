package fianso.io.pidza.models;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="commande")
public class Commande {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "commande_id")
    private int commande_id;
    @Column(name = "commande_etat")
    private String commande_etat;
    @Column(name = "commande_prix")
    private Float commande_prix;

    @ManyToOne
    @JoinColumn(name="magasin_id", nullable=false)  
    private Magasin magasins;

    
    @OneToMany(mappedBy = "commandes_pizza" ,cascade = CascadeType.ALL)
    List<CommandePizza> commandePizzas;

    @OneToMany(mappedBy = "commandes_boisson")
    List<CommandeBoisson> commandeBoissons;

    @OneToMany(mappedBy = "commandes_agent")
    List<CommandeAgent> commandesAgent;

    @OneToMany(mappedBy = "commandes_client")
    List<CommandeClient> commandesClient;
    
    public List<CommandeClient> getCommandesClient() {
        return commandesClient;
    }
    public List<CommandeBoisson> getCommandeBoissons() {
        return commandeBoissons;
    }
    public List<CommandePizza> getCommandePizzas() {
        return commandePizzas;
    }
    public List<CommandeAgent> getCommandesAgent() {
        return commandesAgent;
    }
    public int getCommande_id() {
        return commande_id;
    }
    public String getCommande_etat() {
        return commande_etat;
    }
    public Float getCommande_prix() {
        return commande_prix;
    }
    public Integer getMagasins() {
        return magasins.getMagasin_id();
    }
   
    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }
    public void setCommande_etat(String commande_etat) {
        this.commande_etat = commande_etat;
    }
    public void setCommande_prix(Float commande_prix) {
        this.commande_prix = commande_prix;
    }
    public void setMagasins(Magasin magasins) {
        this.magasins = magasins;
    }
}
