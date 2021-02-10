package fianso.io.pidza.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agent")
public class Agent {
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "agent_id")
    int agent_id;
    @Column(name = "agent_nom")
    private String agent_nom;
    @Column(name = "agent_prenom")
    private String agent_prenom; 
    @Column(name = "agent_email")
    private String agent_email; 
    @Column(name = "agent_password")
    private String agent_password; 
    @Column(name = "agent_username")
    private String agent_username; 
    @Column(name = "agent_adress")
    private String agent_adress; 
    @Column(name = "agent_telephone")
    private String agent_telephone;
    
    @OneToMany(mappedBy = "agent" ,cascade = CascadeType.ALL)
    List<CommandeAgent> agents;

    public int getAgent_id() {
        return agent_id;
    }
    public String getAgent_nom() {
        return agent_nom;
    }
    public String getAgent_email() {
        return agent_email;
    }
    public String getAgent_adress() {
        return agent_adress;
    }
    public String getAgent_password() {
        return agent_password;
    }
    public String getAgent_prenom() {
        return agent_prenom;
    }
    public String getAgent_telephone() {
        return agent_telephone;
    }
    public String getAgent_username() {
        return agent_username;
    }
    public void setAgent_adress(String agent_adress) {
        this.agent_adress = agent_adress;
    }
    public void setAgent_email(String agent_email) {
        this.agent_email = agent_email;
    }
    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }
    public void setAgent_nom(String agent_nom) {
        this.agent_nom = agent_nom;
    }
    public void setAgent_password(String agent_password) {
        this.agent_password = agent_password;
    }
    public void setAgent_prenom(String agent_prenom) {
        this.agent_prenom = agent_prenom;
    }
    public void setAgent_telephone(String agent_telephone) {
        this.agent_telephone = agent_telephone;
    }
    public void setAgent_username(String agent_username) {
        this.agent_username = agent_username;
    }
    
    public void setAgents(List<CommandeAgent> agents) {
        this.agents = agents;
    }
}
