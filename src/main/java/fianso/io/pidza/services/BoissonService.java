package fianso.io.pidza.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.Boisson;
import fianso.io.pidza.repositories.BoissonRepository;

@Service
public class BoissonService {
    @Autowired
    private BoissonRepository boissonRepository;

    public void addBoisson(Boisson boisson){
        boissonRepository.save(boisson);
    }
}
