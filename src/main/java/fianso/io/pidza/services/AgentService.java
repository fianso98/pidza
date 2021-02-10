package fianso.io.pidza.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.Agent;
import fianso.io.pidza.repositories.AgentRepository;

@Service
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;

    public void addAgent(Agent agent ){
        agentRepository.save(agent);
    }
}
