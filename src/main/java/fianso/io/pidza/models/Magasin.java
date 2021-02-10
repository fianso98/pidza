package fianso.io.pidza.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Magasin")
public class Magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "magasin_id")
    private int magasin_id;
    @Column(name = "magasin_nom")
    private String magasin_nom;
    @Column(name = "magasin_wilaya")
    private String magasin_wilaya;  
    @Column(name = "magasin_adress")
    private String magasin_adress; 

    @ManyToOne
    @JoinColumn(name="responsable_id", nullable=false)  
    private Responsable responsables;

    @OneToMany(mappedBy="magasins" , cascade = CascadeType.DETACH , fetch = FetchType.LAZY)
    private List<Commande> commandes;   

    @ManyToMany
    @JoinTable( name = "magasin_pizza_list", 
                joinColumns = @JoinColumn(name = "magasin_id"), 
                inverseJoinColumns = @JoinColumn(name = "pizza_id"))
    List<PizzaList> pizzaLists;

    @ManyToMany
    @JoinTable( name = "magasin_boisson_list", 
                joinColumns = @JoinColumn(name = "magasin_id"), 
                inverseJoinColumns = @JoinColumn(name = "boisson_id"))
    List<BoissonList> boissonLists ;

    @ManyToMany
    @JoinTable( name = "magasin_ingrediant_list", 
                joinColumns = @JoinColumn(name = "magasin_id"), 
                inverseJoinColumns = @JoinColumn(name = "ingrediant_id"))
    List<IngrediantList> ingrediantLists ;

     public int getMagasin_id() {
         return magasin_id;
     }
     public String getMagasin_nom() {
         return magasin_nom;
     }
     public String getMagasin_wilaya() {
         return magasin_wilaya;
     }
     public String getMagasin_adress() {
         return magasin_adress;
     }
     public Responsable getResponsables() {
         return responsables;
     }
     public List<PizzaList> getPizzaLists() {
         return pizzaLists;
     }
     public List<BoissonList> getBoissonLists() {
         return boissonLists;
     }
     public List<IngrediantList> getIngrediantLists() {
         return ingrediantLists;
     }
     public void setMagasin_id(int magasin_id) {
         this.magasin_id = magasin_id;
     }
     public void setMagasin_nom(String magasin_nom) {
         this.magasin_nom = magasin_nom;
     }
     public void setMagasin_wilaya(String magasin_wilaya) {
         this.magasin_wilaya = magasin_wilaya;
     }
     public void setMagasin_adress(String magasin_adress) {
         this.magasin_adress = magasin_adress;
     }
     public void setResponsables(Responsable responsables) {
         this.responsables = responsables;
     }
}
