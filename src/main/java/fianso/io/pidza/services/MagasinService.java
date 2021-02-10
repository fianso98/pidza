package fianso.io.pidza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.Magasin;
import fianso.io.pidza.repositories.MagasinRepository;

@Service
public class MagasinService {
    @Autowired
    private MagasinRepository magasinRepository;

    public List<Magasin> getAllMagasins(){
        List<Magasin> ls = new ArrayList<>();
        magasinRepository.findAll().forEach(ls::add);
        return ls;
    }
    public List<Magasin> getMagasinByAdress(String adress){
        return magasinRepository.findByAddress(adress);
    }
    public void addMagasin(Magasin magasin){
        magasinRepository.save(magasin);
    }
}
