package com.alura.literAlura.repository;

import com.alura.literAlura.modelos.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Long> {

    Optional<Autor> findByNombre(String nombre);
    @Query("SELECT a FROM Autor a WHERE a.annoNacimiento>=:inicio AND a.annoMuerte<=:fin")
    List<Autor> encontrarAutoresEntreFechas(Integer inicio, Integer fin);

//     List<Autor> findByAnnoMuerteBeetweenAnno(Integer annoMuerte);
}

