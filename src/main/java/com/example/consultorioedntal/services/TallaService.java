package com.example.consultorioedntal.services;

import com.example.consultorioedntal.model.Talla;
import com.example.consultorioedntal.repositories.TallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TallaService {

    @Autowired
    private TallaRepository repository;

    public List<Talla> all(){
        List<Talla> tallas = new ArrayList<Talla>();
        repository.findAll().forEach(x -> tallas.add(x));
        return tallas;
    }

    public Talla getById(Long id){
        Talla c = repository.findById(id).orElseGet(null);
        return c;
    }

    public Talla insert(Talla c){
        c.setEstatus("A");
        return repository.save(c);
    }

    public Talla update(Talla c){
        return repository.findById(c.getId())
                .map(talla -> {
                    talla.setNombre(c.getNombre());
                    return repository.save(talla);
                })
                .orElseGet(() -> {
                    return null;
                });
    }

    public Talla enable(Long id){
        return this.changeStatus(id, "A");
    }

    public Talla disable(Long id){
        return this.changeStatus(id, "B");
    }

    private Talla changeStatus(Long id, String s){
        return repository.findById(id)
                .map(talla -> {
                    talla.setEstatus(s);
                    return repository.save(talla);
                })
                .orElseGet(() -> {
                    return null;
                });
    }

    public List<Talla> getActivos(){
        List<Talla> tallas = new ArrayList<Talla>();
        repository.findByEstatus("A").forEach(x -> tallas.add(x));
        return tallas;
    }
}
