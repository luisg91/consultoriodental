package com.example.consultorioedntal.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Color implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private String estatus;

    public Color() {
    }

    public Color(String nombre) {
        this.nombre = nombre;
    }

    public Color(Long id, String nombre) {
        this.nombre = nombre;
        this.id = id;
    }

    public Color(String nombre, String estatus) {
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public Color(Long id, String nombre, String estatus) {
        this.nombre = nombre;
        this.estatus = estatus;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estatus=" + estatus +
                '}';
    }
}