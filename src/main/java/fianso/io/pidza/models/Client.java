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
@Table(name = "client")
public class Client {
    
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    int client_id;
    @Column(name = "client_nom")
    private String client_nom;
    @Column(name = "client_prenom")
    private String client_prenom; 
    @Column(name = "client_email")
    private String client_email; 
    @Column(name = "client_password")
    private String client_password; 
    @Column(name = "client_username")
    private String client_username; 
    @Column(name = "client_adress")
    private String client_adress; 
    @Column(name = "client_telephone")
    private String client_telephone;
    @Column(name = "client_tokken")
    private String client_tokken;
    

    @OneToMany(mappedBy = "clients" ,cascade = CascadeType.ALL)
    List<CommandeClient> client;

    public void setClient(List<CommandeClient> client) {
        this.client = client;
    }
    public int getClient_id() {
        return client_id;
    }
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
    public String getClient_nom() {
        return client_nom;
    }
    public void setClient_nom(String client_nom) {
        this.client_nom = client_nom;
    }
    public String getClient_prenom() {
        return client_prenom;
    }
    public void setClient_prenom(String client_prenom) {
        this.client_prenom = client_prenom;
    }
    public String getClient_email() {
        return client_email;
    }
    public String getClient_adress() {
        return client_adress;
    }
    public String getClient_password() {
        return client_password;
    }
    public String getClient_telephone() {
        return client_telephone;
    }
    public String getClient_tokken() {
        return client_tokken;
    }
    public String getClient_username() {
        return client_username;
    }
    public void setClient_adress(String client_adress) {
        this.client_adress = client_adress;
    }
    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }
    public void setClient_password(String client_password) {
        this.client_password = client_password;
    }
    public void setClient_telephone(String client_telephone) {
        this.client_telephone = client_telephone;
    }
    public void setClient_tokken(String client_tokken) {
        this.client_tokken = client_tokken;
    }
    public void setClient_username(String client_username) {
        this.client_username = client_username;
    }

}
