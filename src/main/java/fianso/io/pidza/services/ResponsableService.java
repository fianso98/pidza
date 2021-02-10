package fianso.io.pidza.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fianso.io.pidza.models.Responsable;
import fianso.io.pidza.repositories.ResponsableRepository;

@Service
public class ResponsableService {
    @Autowired
    private ResponsableRepository responsableRepository;

    public List<Responsable> getAllResponsables(){
        List<Responsable> ls = new ArrayList<>();
        responsableRepository.findAll().forEach(ls::add);
        return ls;
    }
}
