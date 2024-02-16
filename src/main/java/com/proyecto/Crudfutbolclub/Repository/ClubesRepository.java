package com.proyecto.Crudfutbolclub.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyecto.Crudfutbolclub.Documents.ClubesDocuments;

public interface ClubesRepository extends MongoRepository<ClubesDocuments, String>{
    @SuppressWarnings("null")
    Optional<ClubesDocuments> findById(String id);
}
