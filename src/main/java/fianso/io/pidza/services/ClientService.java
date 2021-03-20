package fianso.io.pidza.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.Client;
import fianso.io.pidza.repositories.ClientRepository;

@Service
public class ClientService {
    
     @Autowired
     private ClientRepository clientRepository;

     public Optional<Client> getClientById(int id){
         Optional<Client> client = clientRepository.findById(id);
         if(client.isPresent())
         return client;
         return null;
     }

     public Optional<Client> getClientByUsername(String username){
      Optional<Client> client = clientRepository.findByUsername(username);
      if(client.isPresent())
      return client;
      return null;
     }
     

     public void signInClient(Client client){
        clientRepository.save(client);
     }
     public void updateClient(Client client){
        clientRepository.save(client);
     }
}
