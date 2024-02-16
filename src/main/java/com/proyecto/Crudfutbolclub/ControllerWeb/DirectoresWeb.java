package com.proyecto.Crudfutbolclub.ControllerWeb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.Crudfutbolclub.Documents.DirectoresDocuments;
import com.proyecto.Crudfutbolclub.NotFundException.NotFundException;
import com.proyecto.Crudfutbolclub.Repository.DirectoresRespository;

@RestController
@RequestMapping("/director")
public class DirectoresWeb {

    @Autowired
    private DirectoresRespository directoresRespository;

    @GetMapping("/")
    public List<DirectoresDocuments> finAll(){
        return directoresRespository.findAll();
    }

    @GetMapping("/{id}")
    public DirectoresDocuments findById(@PathVariable String id){
        return directoresRespository.findById(id).orElseThrow(()-> new NotFundException("DIRECTORES NO ENCONTRADA"));
    }

    @SuppressWarnings("null")
    @PostMapping("/")
    public DirectoresDocuments save(@RequestBody Map<String, Object> body){
        ObjectMapper mapper = new ObjectMapper();
        DirectoresDocuments director = mapper.convertValue(mapper, DirectoresDocuments.class);
        return directoresRespository.save(director);
    }

    @SuppressWarnings("null")
    @PostMapping("/{id}")
    public DirectoresDocuments update(@PathVariable String id, @RequestBody Map<String, Object> body){
        ObjectMapper mapper = new ObjectMapper();
        DirectoresDocuments director = mapper.convertValue(body, DirectoresDocuments.class);
        return directoresRespository.save(director);
    }

    @SuppressWarnings("null")
    @DeleteMapping("/{id}")
    public DirectoresDocuments delete(@PathVariable String id){
        DirectoresDocuments director = directoresRespository.findById(id).orElseThrow(()-> new NotFundException("DIRECTORES NO ENCONTRADA"));;
        directoresRespository.deleteById(id);
        return director;
    }    
}