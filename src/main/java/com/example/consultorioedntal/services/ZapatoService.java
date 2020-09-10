package com.example.consultorioedntal.services;

import com.example.consultorioedntal.model.Zapato;
import com.example.consultorioedntal.repositories.ZapatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZapatoService {

    @Autowired
    private ZapatoRepository repository;

    public List<Zapato> all(){
        List<Zapato> zapatos = new ArrayList<Zapato>();
        repository.findAll().forEach(x -> zapatos.add(x));
        return zapatos;
    }

    public Zapato insert(Zapato c){
        return repository.save(c);
    }

    public Zapato update(Zapato c){
        return repository.findById(c.getId())
                .map(zapato -> {
                    zapato.setNombre(c.getNombre());
                    zapato.setDescripcion(c.getDescripcion());
                    zapato.setCosto(c.getCosto());
                    zapato.setPrecio(c.getPrecio());
                    zapato.setColor(c.getColor());
                    zapato.setTallas(c.getTallas());
                    return repository.save(zapato);
                })
                .orElseGet(() -> {
                    return null;
                });
    }

    public void delete(Zapato c){
        repository.delete(c);
    }

}
