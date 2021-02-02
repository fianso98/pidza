package fianso.io.pidza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.Player;
import fianso.io.pidza.repositories.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerService(){
        System.out.println("------service layer created---------");
       
    }
    public List<Player> getAllThePlayers(){
        List<Player> playerList = new ArrayList<>();
        playerRepository.findAll().forEach(playerList::add);
        return playerList;
    }
    //findById(id),save(player),deleteById
}
