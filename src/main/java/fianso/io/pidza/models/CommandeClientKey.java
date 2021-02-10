package fianso.io.pidza.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CommandeClientKey implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Column(name = "commande_id")
    int commandeIdClient;

    @Column(name = "client_id")
    int clientId;

    public int getClientId() {
        return clientId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public int getCommandeIdClient() {
        return commandeIdClient;
    }
    public void setCommandeIdClient(int commandeIdClient) {
        this.commandeIdClient = commandeIdClient;
    }
}
