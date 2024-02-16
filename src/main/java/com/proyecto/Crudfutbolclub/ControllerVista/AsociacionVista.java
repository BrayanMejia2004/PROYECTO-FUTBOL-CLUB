package com.proyecto.Crudfutbolclub.ControllerVista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.Crudfutbolclub.Documents.AsociacionesDocuments;
import com.proyecto.Crudfutbolclub.Repository.AsociacionesRepository;

@Controller
@RequestMapping("asociaciones")
public class AsociacionVista {

    @Autowired
    private AsociacionesRepository asociacionesRepository;

    @GetMapping("/regresar")
    public String regresar(Model model) {
        model.addAttribute("asociaciones", asociacionesRepository.findAll());
        return "/index/index";
    }

    @GetMapping("/listarAsociaciones")
    public String listarAsociaciones(Model model) {
        model.addAttribute("asociaciones", asociacionesRepository.findAll());
        return "/Asociacion/Asociaciones";
    }

    @GetMapping("/crearAsociacion")
    public String crearAsociacion(Model model) {
        model.addAttribute("asociaciones", new AsociacionesDocuments());
        return "/Asociacion/Asociaciones";
    }

    @GetMapping("/editarAsociacion/{id}")
    public String editarAsociacion(@PathVariable String id, Model model) throws NotFoundException {

        AsociacionesDocuments asociacion = asociacionesRepository.findById(id).orElseThrow(() -> new NotFoundException());
        model.addAttribute("asociacion", asociacion);
        return "/Asociacion/EditarAsociacion";
    }

    @SuppressWarnings("null")
    @PostMapping("/guardarAsociacion")
    public String guardarAsociacion(@ModelAttribute("asociacion") AsociacionesDocuments asociacion) {  
        asociacionesRepository.save(asociacion);
        return "redirect:/asociaciones/listarAsociaciones";
    }

    @SuppressWarnings("null")
    @GetMapping("/eliminarAsociacion/{id}")
    public String eliminarAsociacion(@PathVariable("id") String id) {
        asociacionesRepository.deleteById(id);
        return "redirect:/asociaciones/listarAsociaciones";
    }
}
