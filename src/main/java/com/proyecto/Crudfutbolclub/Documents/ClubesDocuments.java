package com.proyecto.Crudfutbolclub.Documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import jakarta.validation.constraints.NotEmpty;

@Document()
public class ClubesDocuments {

    @Id
    private String id;

    @NotEmpty
    private String nombre;

    @DocumentReference
    private DirectoresDocuments directores;

    @DocumentReference
    private List<JugadoresDocuments> jugadores;

    @DocumentReference
    private AsociacionesDocuments asociaciones;

    @DocumentReference
    private List<CompetenciasDocuments> competencias;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DirectoresDocuments getDirectores() {
        return directores;
    }

    public void setDirectores(DirectoresDocuments directores) {
        this.directores = directores;
    }

    public List<JugadoresDocuments> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<JugadoresDocuments> jugadores) {
        this.jugadores = jugadores;
    }

    public AsociacionesDocuments getAsociaciones() {
        return asociaciones;
    }

    public void setAsociaciones(AsociacionesDocuments asociaciones) {
        this.asociaciones = asociaciones;
    }

    public List<CompetenciasDocuments> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(List<CompetenciasDocuments> competencias) {
        this.competencias = competencias;
    }

}
