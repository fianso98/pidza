package fianso.io.pidza.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Responsable")
public class Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "responsable_id")
    private int responsable_id;
    @Column(name = "responsable_nom")
    private String responsable_nom;
    @Column(name = "responsable_prenom")
    private String responsable_prenom; 
    @Column(name = "responsable_username")
    private String responsable_username; 
    @Column(name = "responsable_password")
    private String responsable_password; 
    @Column(name = "responsable_email")
    private String responsable_email; 
    

    @OneToMany(mappedBy="responsables" , cascade = CascadeType.DETACH , fetch = FetchType.LAZY)
    private List<Magasin> magasins;     
    
    public int getResponsable_id() {
        return responsable_id;
    }
    public String getResponsable_nom() {
        return responsable_nom;
    }
    public String getResponsable_prenom() {
        return responsable_prenom;
    }
    public String getResponsable_username() {
        return responsable_username;
    }
    public String getResponsable_email() {
        return responsable_email;
    }
    public String getResponsable_password() {
        return responsable_password;
    }
    /*public List<Magasin> getMagasins() {
        return magasins;
    }*/
    public void setResponsable_id(int responsable_id) {
        this.responsable_id = responsable_id;
    }
    public void setResponsable_nom(String responsable_nom) {
        this.responsable_nom = responsable_nom;
    }
    public void setResponsable_prenom(String responsable_prenom) {
        this.responsable_prenom = responsable_prenom;
    }
    public void setResponsable_username(String responsable_username) {
        this.responsable_username = responsable_username;
    }
    public void setResponsable_email(String responsable_email) {
        this.responsable_email = responsable_email;
    }
    public void setResponsable_password(String responsable_password) {
        this.responsable_password = responsable_password;
    }
    /*public void setMagasins(List<Magasin> magasins) {
        this.magasins = magasins;
    }*/
}
