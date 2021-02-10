package fianso.io.pidza.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name ="commande_agent")
public class CommandeAgent {
    @EmbeddedId
    CommandeAgentKey id = new CommandeAgentKey();

    @ManyToOne
    @MapsId("commandeIdAgent")
    @JoinColumn(name = "commande_id" , nullable = false)
    Commande commandes_agent;

    @ManyToOne
    @MapsId("agentId")
    @JoinColumn(name = "agent_id" , nullable = false)
    Agent agent;

    @Column(name = "etat")
    String etat;
    @Column(name = "raison")
    String raison;

    public void setId(CommandeAgentKey id) {
        this.id = id;
    }
    public Agent getAgent() {
        return agent;
    }
    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    public String getEtat() {
        return etat;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }
    public String getRaison() {
        return raison;
    }
    public void setRaison(String raison) {
        this.raison = raison;
    }
    public void setCommandes_agent(Commande commandes_agent) {
        this.commandes_agent = commandes_agent;
    }

}
