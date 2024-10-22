package fianso.io.pidza.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fianso.io.pidza.models.Agent;
import fianso.io.pidza.models.Commande;
import fianso.io.pidza.models.CommandeAgent;
import fianso.io.pidza.models.CommandeBoisson;
import fianso.io.pidza.models.CommandeClient;
import fianso.io.pidza.models.CommandePizza;
import fianso.io.pidza.models.LoginForm;
import fianso.io.pidza.models.Magasin;
import fianso.io.pidza.models.Responsable;
import fianso.io.pidza.services.AgentService;
import fianso.io.pidza.services.CommandeAgentService;
import fianso.io.pidza.services.CommandeBoissonService;
import fianso.io.pidza.services.CommandeClientService;
import fianso.io.pidza.services.CommandePizzaService;
import fianso.io.pidza.services.CommandeService;
import fianso.io.pidza.services.MagasinService;
import fianso.io.pidza.services.ResponsableService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ResponsableController {
    @Autowired
    private ResponsableService responsableService;

    @Autowired
    private CommandeService commandeService;
    
    @Autowired
    private CommandePizzaService commandePizzaService;

    @Autowired
    private CommandeBoissonService commandeBoissonService;

    @Autowired 
    private MagasinService magasinService;

    @Autowired
    private CommandeAgentService commandeAgentService;

    @Autowired
    private CommandeClientService commandeClientService;

    @GetMapping(value = "responsables")
    public List<Responsable> getAllResponsables() {
        return responsableService.getAllResponsables();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/api/responsable/getallcommandes/{idResponsable}")
    public List<Commande> getAllCommandes(@PathVariable int idResponsable) {

        return commandeService.getCommandeByResponsable(idResponsable);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/api/responsable/getcommandes/{idResponsable}")
    public List<Commande> getCommandes(@PathVariable int idResponsable) {

        return commandeService.getCommandeReadyByResponsable(idResponsable);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/api/responsable/login")
    public ObjectNode loginClient(@RequestBody LoginForm loginForm){
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        Optional<Responsable> responsable = responsableService.getResponsableByUsername(username);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        if(responsable==null){
            
            objectNode.put("message", "please register before continuing");
            return objectNode;
        }else {
            String responsablePasswordInDatabase = responsable.get().getResponsable_password();
            if (password.equals(responsablePasswordInDatabase)){ 
                objectNode.put("id", responsable.get().getResponsable_id());
                objectNode.put("message", "login with success");
                return objectNode;
            }else{
                objectNode.put("message", "invalid password please try again");
                return objectNode;
            }
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/api/responsable/startcommande/{idCommande}")
    public void getMethodName(@RequestBody ObjectNode json,@PathVariable int idCommande ) {
        Optional<Commande> opCom=commandeService.getCommandesById(idCommande);
        Commande commande = opCom.get();
        commande.setCommande_etat("lancer");
        JsonNode agentJson = json.get("add_commande_agent");            
        ObjectMapper mapper = new ObjectMapper();
        ((ObjectNode)agentJson).putObject("commandes_agent").put("commande_id", idCommande);
        CommandeAgent agent;
        try {
            System.out.println(agentJson);
            agent = mapper.treeToValue(agentJson, CommandeAgent.class);
            commandeAgentService.addCommandeAgent(agent);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
