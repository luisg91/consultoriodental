package com.example.consultorioedntal.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Zapato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private BigDecimal costo;
    @Column
    private BigDecimal precio;
    @ManyToOne(fetch = FetchType.LAZY)
    private Color color;
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Talla> tallas;

    public Zapato() { }

    public Zapato(String nombre, String descripcion, BigDecimal costo, BigDecimal precio, Color color, List<Talla> tallas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precio = precio;
        this.color = color;
        this.tallas = tallas;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Talla> getTallas() {
        return tallas;
    }

    public void setTallas(List<Talla> tallas) {
        this.tallas = tallas;
    }

    @Override
    public String toString() {
        return "Zapato{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", costo=" + costo +
                ", precio=" + precio +
                ", color=" + color +
                ", tallas=" + tallas +
                '}';
    }
}