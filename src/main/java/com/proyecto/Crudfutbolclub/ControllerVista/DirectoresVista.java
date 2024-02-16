package com.proyecto.Crudfutbolclub.ControllerVista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.Crudfutbolclub.Documents.DirectoresDocuments;
import com.proyecto.Crudfutbolclub.Repository.DirectoresRespository;

@Controller
@RequestMapping("directores")
public class DirectoresVista {

    @Autowired
    private DirectoresRespository directoresRespository;

    @GetMapping("/regresar")
    public String regresar(Model model) {
        model.addAttribute("directores", directoresRespository.findAll());
        return "/index/index";
    }

    @GetMapping("/listarDirectores")
    public String listarDirectores(Model model) {
        model.addAttribute("directores", directoresRespository.findAll());
        return "/Director/Directores";
    }

    @GetMapping("/crearDirector")
    public String crearDirector(Model model) {
        model.addAttribute("director", new DirectoresDocuments());
        return "/Director/Directores";
    }

    @GetMapping("/editarDirector/{id}")
    public String editarDirector(@PathVariable String id, Model model) throws NotFoundException {
        DirectoresDocuments director = directoresRespository.findById(id).orElseThrow(() -> new NotFoundException());
        model.addAttribute("director", director);
        return "/Director/EditarDirectores";
    }

    @SuppressWarnings("null")
    @PostMapping("/guardarDirector")
    public String guardarDirector(DirectoresDocuments director) {
        directoresRespository.save(director);
        return "redirect:/directores/listarDirectores";
    }

    @SuppressWarnings("null")
    @GetMapping("/eliminarDirector/{id}")
    public String eliminarDirecto(@PathVariable("id") String id) {
        directoresRespository.deleteById(id);
        return "redirect:/directores/listarDirectores";
    }
    
}
