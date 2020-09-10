package com.example.consultorioedntal.repositories;

import com.example.consultorioedntal.model.Zapato;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZapatoRepository extends CrudRepository<Zapato, Long> {

    List<Zapato> findByNombre(String name);

}