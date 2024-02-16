package com.proyecto.Crudfutbolclub.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyecto.Crudfutbolclub.Documents.AsociacionesDocuments;

public interface AsociacionesRepository extends MongoRepository<AsociacionesDocuments, String>{
    @SuppressWarnings("null")
    Optional<AsociacionesDocuments> findById(String id);
}
