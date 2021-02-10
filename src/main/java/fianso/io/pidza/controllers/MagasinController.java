package fianso.io.pidza.controllers;
import fianso.io.pidza.models.Magasin;
import fianso.io.pidza.services.MagasinService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MagasinController {
    @Autowired
    private MagasinService magasinService;

    @GetMapping(value = "magasins")
    public List<Magasin> getAllMagasins(){
        return magasinService.getAllMagasins();
    }
}
