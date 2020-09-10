package com.example.consultorioedntal.repositories;


import com.example.consultorioedntal.model.Talla;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TallaRepository extends CrudRepository<Talla, Long> {

    List<Talla> findByEstatus(String estatus);

}