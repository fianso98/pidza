package fianso.io.pidza.controllers;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fianso.io.pidza.models.Boisson;
import fianso.io.pidza.models.Client;
import fianso.io.pidza.models.Commande;
import fianso.io.pidza.models.CommandeBoisson;
import fianso.io.pidza.models.CommandeBoissonKey;
import fianso.io.pidza.models.CommandeClient;
import fianso.io.pidza.models.CommandeClientKey;
import fianso.io.pidza.models.CommandePizza;
import fianso.io.pidza.models.CommandePizzaKey;
import fianso.io.pidza.models.Ingrediant;
import fianso.io.pidza.models.Magasin;
import fianso.io.pidza.models.Pizza;
import fianso.io.pidza.repositories.MagasinRepository;
import fianso.io.pidza.services.BoissonService;
import fianso.io.pidza.services.ClientService;
import fianso.io.pidza.services.CommandeAgentService;
import fianso.io.pidza.services.CommandeBoissonService;
import fianso.io.pidza.services.CommandeClientService;
import fianso.io.pidza.services.CommandePizzaService;
import fianso.io.pidza.services.CommandeService;
import fianso.io.pidza.services.IngrediantService;
import fianso.io.pidza.services.MagasinService;
import fianso.io.pidza.services.PizzaService;

@RestController
public class ClientController {
    @Autowired
    private MagasinService magasinService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private CommandeService commandeService;
    
    @Autowired
    private CommandePizzaService commandePizzaService;

    @Autowired
    private CommandeBoissonService commandeBoissonService;


    @Autowired
    private CommandeAgentService commandeAgentService;

    @Autowired
    private CommandeClientService commandeClientService;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private IngrediantService ingrediantService;

    @Autowired
    private BoissonService boissonService;
    @GetMapping(value = "/api/client/consult")
    public List<Magasin> consultPizzaDisponible(){
        return magasinService.getAllMagasins();
    }
    @GetMapping(value = "/api/client/consult/{idClient}")
    public List<Magasin> magasinsPlusProche(@PathVariable int idClient){
        Optional<Client> client = clientService.getClientById(idClient);
        Client clientModel= client.get();
        String clientAdress = clientModel.getClient_adress();
        return magasinService.getMagasinByAdress(clientAdress);
    }
    @PostMapping(value = "/api/client/signin")
    public void clientNouveauCompte(@RequestBody Client client){
        clientService.signInClient(client);
    }
    @PutMapping(value = "/api/client/update")
    public void clientUpdateCompte(@RequestBody Client client){
        clientService.updateClient(client);
    }
    @PostMapping(value = "/api/client/createcommande")
    public void clientCreateCommande(@RequestBody ObjectNode json){

       

        /*
        JsonNode pizzaJson = json.get("add_commande_pizza");
        JsonNode boissonJson = json.get("add_commande_boisson");        
        */
        
        JsonNode commandeJson = json.get("add_commande");

       
        ObjectMapper mapper = new ObjectMapper();

        
    
        
        try {
            
            //ajout de la commande
            Commande commande =  mapper.treeToValue(commandeJson, Commande.class);

            commandeService.addCommande(commande);
            int idCommande = commande.getCommande_id();
            
            
            
            //client
            //((ObjectNode)clientJson).putObject("commandes_client").put("commande_id", idCommande);
            //CommandeClient client =  mapper.treeToValue(clientJson, CommandeClient.class);
            //commandeClientService.addCommandeClient(client);            
            
            for (JsonNode node : json.get("add_commande_client")) {
          
                JsonNode clientJson=  node.get("clients");
                JsonNode adressClientJson=  node.get("adress_livraison");
                //CommandePizza pizza =  mapper.treeToValue(pizzaJson, CommandePizza.class);
                //commandePizzaService.addCommandePizza(pizza);
                //get pizza class from json
                Client client =  mapper.treeToValue(clientJson, Client.class); 
                //set commandeBoisson
                CommandeClient commandeClient = new CommandeClient();
                CommandeClientKey id = new CommandeClientKey();
                id.setCommandeIdClient(idCommande);
                id.setClientId(client.getClient_id());
                commandeClient.setId(id);    
                commandeClient.setCommandes_client(commande);    
                commandeClient.setClients(client);
                commandeClient.setAdress_livraison(adressClientJson.toString()); 
                //insert into database  
                commandeClientService.addCommandeClient(commandeClient);
            }

            //pizza
            
            for (JsonNode node : json.get("add_commande_pizza")) {
          
                JsonNode pizzaJson=  node.get("pizzas");
                JsonNode nombreJson=  node.get("nombre_pizza");
                //CommandePizza pizza =  mapper.treeToValue(pizzaJson, CommandePizza.class);
                //commandePizzaService.addCommandePizza(pizza);
                //get pizza class from json
                Pizza pizza =  mapper.treeToValue(pizzaJson, Pizza.class); 
                //if pizza id not mantiened then create a new pizza 
                if(pizza.getPizza_id() == 0){
                    List<Ingrediant> ls = pizza.getIngrediants();
                    for (Ingrediant ingrediant : ls) {
                        if(ingrediant.getIngrediant_id() ==0){
                                ingrediantService.addIngrediant(ingrediant);
                        }
                    }
                    pizzaService.addPizza(pizza);
                    

                }
                //set commandePizza
                CommandePizza commandePizza = new CommandePizza();
                CommandePizzaKey id = new CommandePizzaKey();
                id.setCommandeIdPizza(idCommande);
                id.setPizza_id(pizza.getPizza_id());
                commandePizza.setId(id);    
                commandePizza.setCommandes_pizza(commande);    
                commandePizza.setPizzas(pizza);
                commandePizza.setNombre_pizza(Integer.parseInt(nombreJson.toString())); 
                //insert into database  
                commandePizzaService.addCommandePizza(commandePizza);
            }
            for (JsonNode node : json.get("add_commande_boisson")) {
          
                JsonNode boissonJson=  node.get("boissons");
                JsonNode nombreJson=  node.get("nombre_boisson");
                //get boisson class from json
                Boisson boisson =  mapper.treeToValue(boissonJson, Boisson.class); 
                //if boisson id not mantiened then create a new boisson 
                if(boisson.getBoisson_id() == 0){
                    boissonService.addBoisson(boisson);

                }

                //set commandeBoisson
                CommandeBoisson commandeBoisson = new CommandeBoisson();
                CommandeBoissonKey id = new CommandeBoissonKey();
                id.setCommandeIdBoisson(idCommande);
                id.setBoissonId(boisson.getBoisson_id());
                commandeBoisson.setId(id);    
                commandeBoisson.setCommandes_boisson(commande);    
                commandeBoisson.setBoissons(boisson);
                commandeBoisson.setNombre_boisson(Integer.parseInt(nombreJson.toString())); 
                //insert into database  
                commandeBoissonService.addCommandeBoisson(commandeBoisson);
                
            }
           
           
           
            
            
             } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   
            
            
           
       
    }
}
