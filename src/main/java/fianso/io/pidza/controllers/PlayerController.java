package fianso.io.pidza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import fianso.io.pidza.services.PlayerService;
import fianso.io.pidza.models.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @GetMapping(value="player")
    public List<Player> getPlayers() {
        return playerService.getAllThePlayers();
    }
    

}
