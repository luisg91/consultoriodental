package com.example.consultorioedntal.services;


import com.example.consultorioedntal.model.Color;
import com.example.consultorioedntal.repositories.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService {

    @Autowired
    private ColorRepository repository;

    public List<Color> all(){
        List<Color> colroes = new ArrayList<Color>();
        repository.findAll().forEach(x -> colroes.add(x));
        return colroes;
    }

    public Color getById(Long id){
        Color c = repository.findById(id).orElseGet(null);
        return c;
    }

    public Color insert(Color c){
        c.setEstatus("A");
        return repository.save(c);
    }

    public Color update(Color c){
        return repository.findById(c.getId())
                .map(color -> {
                    color.setNombre(c.getNombre());
                    return repository.save(color);
                })
                .orElseGet(() -> {
                    return null;
                });
    }

    public Color enable(Long id){
        return this.changeStatus(id, "A");
    }

    public Color disable(Long id){
        return this.changeStatus(id, "B");
    }

    private Color changeStatus(Long id, String s){
        return repository.findById(id)
                .map(color -> {
                    color.setEstatus(s);
                    return repository.save(color);
                })
                .orElseGet(() -> {
                    return null;
                });
    }

    public List<Color> getActivos(){
        List<Color> colores = new ArrayList<Color>();
        repository.findByEstatus("A").forEach(x -> colores.add(x));
        return colores;
    }
}
