package com.proyecto.Crudfutbolclub.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyecto.Crudfutbolclub.Documents.DirectoresDocuments;

public interface DirectoresRespository extends MongoRepository<DirectoresDocuments, String>{
    @SuppressWarnings("null")
    Optional<DirectoresDocuments> findById(String id);
}
