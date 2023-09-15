package com.example.lab05_20206438.Controllers;


import com.example.lab05_20206438.Entity.Viaje;
import com.example.lab05_20206438.Repository.LugaresRepository;
import com.example.lab05_20206438.Repository.PersonaRepository;
import com.example.lab05_20206438.Repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/viajes")
public class ViajesController {

    final
    ViajeRepository viajeRepository;
    final PersonaRepository personaRepository;
    final LugaresRepository lugaresRepository;

    public ViajesController(ViajeRepository viajeRepository,
                            PersonaRepository personaRepository,
                            LugaresRepository lugaresRepository) {
        this.viajeRepository = viajeRepository;
        this.personaRepository=personaRepository;
        this.lugaresRepository=lugaresRepository;
    }


    @GetMapping(value={"/lista",""})
    public String listaViajes(Model model){
        model.addAttribute("listaViajes",viajeRepository.findAll());
        return "viajes/lista";
    }
    @GetMapping("/nuevoViaje")
    public String nuevoViaje(Model model){
        model.addAttribute("listaPersonas",personaRepository.findAll());
        model.addAttribute("listaLugares",lugaresRepository.findAll());
        return"viajes/nuevoViaje";
    }
    @PostMapping("/guardar")
    public String guardarNuevoViaje(Viaje viajes){
        viajeRepository.save(viajes);
        return "redirect:viajes/lista";
    }
    @GetMapping("/editar")
    public String editarViaje(Model model,
                                      @RequestParam("id") int id) {

        Optional<Viaje> optShipper = viajeRepository.findById(id);

        if (optShipper.isPresent()) {
            Viaje viajes = optShipper.get();
            model.addAttribute("shipper", viajes);
            return "viajes/editar";
        } else {
            return "redirect:/viajes/lista";
        }
    }
    @GetMapping("/borrar")
    public String borrarViaje(Model model,
                                      @RequestParam("id") int id) {

        Optional<Viaje> optShipper = viajeRepository.findById(id);

        if (optShipper.isPresent()) {
            viajeRepository.deleteById(id);
        }
        return "redirect:/viajes/list";

    }



}
