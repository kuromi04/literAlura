package com.alura.literAlura.modelos;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(unique = true)
    private String nombre;

    private Integer annoNacimiento;
    private Integer annoMuerte;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor() {}

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.annoNacimiento = datosAutor.fechaDeNacimiento();
        this.annoMuerte = datosAutor.fechaDeMuerte();
    }

    @Override
    public String toString() {
        String autor =  "\n__________________________________"+
                "\n!!!!!!!!!! Autores !!!!!!!!!!!!!!"+
                "\nAutor: "+ this.nombre+
                "\nAño nacimiento: " + this.annoNacimiento+
                "\nAño fallecimiento: "+this.annoMuerte+
                "\nLibros"+ libros.stream().map(Libro::getTitulo).collect(Collectors.toList());

        String footer = "\n==================================";
        return autor+footer;
    }

    // Getters y Setters

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Integer getAnnoNacimiento() {
        return annoNacimiento;
    }

    public void setAnnoNacimiento(Integer annoNacimiento) {
        this.annoNacimiento = annoNacimiento;
    }

    public Integer getAnnoMuerte() {
        return annoMuerte;
    }

    public void setAnnoMuerte(Integer annoMuerte) {
        this.annoMuerte = annoMuerte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        libros.forEach(l -> l.setAutor(this));
        this.libros = libros;
    }
}
