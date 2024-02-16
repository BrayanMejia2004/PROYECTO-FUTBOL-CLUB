package com.proyecto.Crudfutbolclub.ControllerVista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.Crudfutbolclub.Documents.JugadoresDocuments;
import com.proyecto.Crudfutbolclub.Repository.JugadoresRepository;

@Controller
@RequestMapping("jugadores")
public class JugadoresVista {

    @Autowired
    private JugadoresRepository jugadoresRepository;

    @GetMapping("/regresar")
    public String regresar(Model model) {
        model.addAttribute("jugadores", jugadoresRepository.findAll());
        return "/index/index";
    }

    @GetMapping("/listarJugadores")
    public String listarJugadores(Model model) {
        model.addAttribute("jugadores", jugadoresRepository.findAll());
        return "/Jugador/Jugadores";
    }

    @GetMapping("/crearJugadores")
    public String crearJugadores(Model model) {
        model.addAttribute("jugadores", new JugadoresDocuments());
        return "/Jugador/Jugadores";
    }

    @GetMapping("/editarJugadores/{id}")
    public String editarJugadores(@PathVariable String id, Model model) throws NotFoundException {

        JugadoresDocuments jugador = jugadoresRepository.findById(id).orElseThrow(() -> new NotFoundException());
        model.addAttribute("jugador", jugador);
        return "/Jugador/EditarJugador";
    }

    @SuppressWarnings("null")
    @PostMapping("/guardarJugadores")
    public String guardarJugadores(JugadoresDocuments jugador) {
        jugadoresRepository.save(jugador);
        return "redirect:/jugadores/listarJugadores";
    }

    @SuppressWarnings("null")
    @GetMapping("/eliminarJugadores/{id}")
    public String eliminarJugadores(@PathVariable("id") String id) {
        jugadoresRepository.deleteById(id);
        return "redirect:/jugadores/listarJugadores";
    }
    
}
