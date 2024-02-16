package com.proyecto.Crudfutbolclub.ControllerWeb;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.Crudfutbolclub.Documents.CompetenciasDocuments;
import com.proyecto.Crudfutbolclub.NotFundException.NotFundException;
import com.proyecto.Crudfutbolclub.Repository.CompetenciasRepository;

@RestController
@RequestMapping("/competencia")
public class CompetenciasWeb {

    @Autowired
    private CompetenciasRepository competenciasRepository;

    @GetMapping("/")
    public List<CompetenciasDocuments> finAll(){
        return competenciasRepository.findAll();
    }

    @GetMapping("/{id}")
    public CompetenciasDocuments findById(@PathVariable String id){
        return competenciasRepository.findById(id).orElseThrow(()-> new NotFundException("COMPETENCIA NO ENCONTRADA"));
    }

    @SuppressWarnings("null")
    @PostMapping("/")
    public CompetenciasDocuments save(@RequestBody Map<String, Object> body){    
        ObjectMapper mapper = new ObjectMapper();
        CompetenciasDocuments competencias = mapper.convertValue(body, CompetenciasDocuments.class);
        return competenciasRepository.save(competencias);
    }

    @SuppressWarnings("null")
    @PutMapping("/{id}")
    public CompetenciasDocuments update(@PathVariable String id, @RequestBody Map<String, Object> body){
        ObjectMapper mapper = new ObjectMapper();
        CompetenciasDocuments competencias = mapper.convertValue(body, CompetenciasDocuments.class);
        return competenciasRepository.save(competencias);
    }

    @SuppressWarnings("null")
    @DeleteMapping("/{id}")
    public CompetenciasDocuments delete(@PathVariable String id){
        CompetenciasDocuments competencia = competenciasRepository.findById(id).orElseThrow(()-> new NotFundException("COMPETENCIA NO ENCONTRADA"));;
        competenciasRepository.deleteById(id);
        return competencia;
    } 
}
