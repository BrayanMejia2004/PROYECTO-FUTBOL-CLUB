package com.proyecto.Crudfutbolclub.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyecto.Crudfutbolclub.Documents.JugadoresDocuments;

public interface JugadoresRepository extends MongoRepository<JugadoresDocuments, String>{
    @SuppressWarnings("null")
    Optional<JugadoresDocuments> findById(String id);
}
