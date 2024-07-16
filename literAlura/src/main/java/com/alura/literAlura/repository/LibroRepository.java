package com.alura.literAlura.repository;

import com.alura.literAlura.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTitulo(String nombre);

    Optional<Libro> findByAutor(AutorRepository autor);

    @Query("SELECT l FROM Libro l WHERE l.idioma = :idioma")
    List<Libro> encontrarPorIdioma(String idioma);
}
// @Query
// List<Autor> encontrarEntreAños();
// @Query("SELECT a FROM Libro l WHERE a.id = :id")
// List<Libro> obtenerLibroDeAutor(int id);
