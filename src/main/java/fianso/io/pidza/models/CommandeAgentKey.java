package fianso.io.pidza.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CommandeAgentKey implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Column(name = "commande_id")
    int commandeIdAgent;

    @Column(name = "agent_id")
    int agentId;

    public int getAgentId() {
        return agentId;
    }
    public int getCommandeIdAgent() {
        return commandeIdAgent;
    }
    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }
    public void setCommandeIdAgent(int commandeIdAgent) {
        this.commandeIdAgent = commandeIdAgent;
    }
}
