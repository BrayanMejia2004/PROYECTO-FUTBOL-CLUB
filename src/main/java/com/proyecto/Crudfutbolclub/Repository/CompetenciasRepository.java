package com.proyecto.Crudfutbolclub.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyecto.Crudfutbolclub.Documents.CompetenciasDocuments;

public interface CompetenciasRepository extends MongoRepository<CompetenciasDocuments, String>{
    @SuppressWarnings("null")
    Optional<CompetenciasDocuments> findById(String id); 
}
