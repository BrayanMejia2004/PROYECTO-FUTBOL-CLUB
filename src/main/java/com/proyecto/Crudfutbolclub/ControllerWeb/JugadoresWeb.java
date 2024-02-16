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
import com.proyecto.Crudfutbolclub.Documents.JugadoresDocuments;
import com.proyecto.Crudfutbolclub.NotFundException.NotFundException;
import com.proyecto.Crudfutbolclub.Repository.JugadoresRepository;

@RestController
@RequestMapping("/jugador")
public class JugadoresWeb {

    @Autowired
    private JugadoresRepository jugadoresRepository;

    @GetMapping("/")
    public List<JugadoresDocuments> finAll(){
        return jugadoresRepository.findAll();
    }

    @GetMapping("/{id}")
    public JugadoresDocuments finAllById(@PathVariable String id){
        return jugadoresRepository.findById(id).orElseThrow(()-> new NotFundException("JUGADOR NO ENCONTRADA"));
    }

    @SuppressWarnings("null")
    @PostMapping("/")
    public JugadoresDocuments save(@RequestBody Map<String, Object> body){
        ObjectMapper mapper = new ObjectMapper();
        JugadoresDocuments jugador = mapper.convertValue(body, JugadoresDocuments.class);
        return jugadoresRepository.save(jugador);
    }

    @PutMapping("/{id}")
    public JugadoresDocuments update(@PathVariable String id, @RequestBody Map<String, Object> body){
         ObjectMapper mapper = new ObjectMapper();
        JugadoresDocuments jugador = mapper.convertValue(body, JugadoresDocuments.class);
        jugador.setId(id);
        return jugadoresRepository.save(jugador);
    }
    
    @SuppressWarnings("null")
    @DeleteMapping("/{id}")
    public JugadoresDocuments delete(@PathVariable String id){
        JugadoresDocuments jugador = jugadoresRepository.findById(id).orElseThrow(()-> new NotFundException("JUGADOR NO ENCONTRADA"));        
        jugadoresRepository.deleteById(id);
        return jugador;
    }
}
