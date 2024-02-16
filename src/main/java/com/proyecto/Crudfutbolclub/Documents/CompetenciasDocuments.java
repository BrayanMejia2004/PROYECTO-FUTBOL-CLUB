package com.proyecto.Crudfutbolclub.Documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class CompetenciasDocuments {

    @Id
    private String id;
    private String nombres;
    private String premio;
    private String fechaIncial;
    private String fechaFinal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public String getFechaIncial() {
        return fechaIncial;
    }

    public void setFechaIncial(String fechaIncial) {
        this.fechaIncial = fechaIncial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}
