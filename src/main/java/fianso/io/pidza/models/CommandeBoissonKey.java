package fianso.io.pidza.models;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CommandeBoissonKey implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "commande_id")
    int commandeIdBoisson;

    @Column(name = "boisson_id")
    int boissonId;

    public int getBoissonId() {
        return boissonId;
    }
    public int getCommandeIdBoisson() {
        return commandeIdBoisson;
    }
    public void setBoissonId(int boissonId) {
        this.boissonId = boissonId;
    }
    public void setCommandeIdBoisson(int commandeIdBoisson) {
        this.commandeIdBoisson = commandeIdBoisson;
    }
}
