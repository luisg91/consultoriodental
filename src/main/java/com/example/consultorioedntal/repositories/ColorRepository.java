package com.example.consultorioedntal.repositories;

import com.example.consultorioedntal.model.Color;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ColorRepository extends CrudRepository<Color, Long> {

    List<Color> findByEstatus(String estatus);

}