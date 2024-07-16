package com.alura.literAlura.modelos.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosResponse(
        @JsonAlias("count") Integer encontrados,
        @JsonAlias("results") List<DatosLibros> datosLibros

) {

}