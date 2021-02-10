package fianso.io.pidza.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="commande_client")
public class CommandeClient {
    
    @EmbeddedId
    CommandeClientKey id = new CommandeClientKey();

    @ManyToOne
    @MapsId("commandeIdClient")
    @JoinColumn(name = "commande_id" , nullable = false)
    Commande commandes_client;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id" , nullable = false)
    Client clients;

    @Column(name = "adress_livraison")
    String adress_livraison;

    public void setId(CommandeClientKey id) {
        this.id = id;
    }
    public Client getClients() {
        return clients;
    }
    public void setClients(Client clients) {
        this.clients = clients;
    }
    public String getAdress_livraison() {
        return adress_livraison;
    }
    public void setAdress_livraison(String adress_livraison) {
        this.adress_livraison = adress_livraison;
    }
    public void setCommandes_client(Commande commandes_client) {
        this.commandes_client = commandes_client;
    }

}
