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

import com.proyecto.Crudfutbolclub.Documents.CompetenciasDocuments;
import com.proyecto.Crudfutbolclub.Repository.CompetenciasRepository;

@Controller
@RequestMapping("competencias")
public class CompetenciasVista {
    
    @Autowired
    private CompetenciasRepository competenciasRepository;

    @GetMapping("/regresar")
    public String regresar(Model model) {
        model.addAttribute("competencias", competenciasRepository.findAll());
        return "/index/index";
    }

    @GetMapping("/listarCompetencias")
    public String listarCompetencias(Model model) {
        model.addAttribute("competencias", competenciasRepository.findAll());
        return "/Competencia/Competencias";
    }

    @GetMapping("/crearCompetencias")
    public String crearCompetencias(Model model) {
        model.addAttribute("competencias", new CompetenciasDocuments());
        return "/Competencia/Competencias";
    }

    @GetMapping("/editarCompetencia/{id}")
    public String editarCompetencias(@PathVariable String id, Model model) throws NotFoundException {
        CompetenciasDocuments competencia = competenciasRepository.findById(id).orElseThrow(() -> new NotFoundException());
        model.addAttribute("competencia", competencia);
        return "/Competencia/EditarCompetencia";
    }

    @SuppressWarnings("null")
    @PostMapping("/guardarCompetencia")
    public String guardarCompetencia(@ModelAttribute("competencia") CompetenciasDocuments competencia) {
        competenciasRepository.save(competencia);
        return "redirect:/competencias/listarCompetencias";
    }

    @SuppressWarnings("null")
    @GetMapping("/eliminarCompetencia/{id}")
    public String eliminarCompetencias(@PathVariable("id") String id) {
        competenciasRepository.deleteById(id);
        return "redirect:/competencias/listarCompetencias";
    }
}
