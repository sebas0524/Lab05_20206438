package com.example.lab05_20206438.Controllers;

import com.example.lab05_20206438.Entity.Mascotas;
import com.example.lab05_20206438.Entity.Viaje;
import com.example.lab05_20206438.Repository.LugaresRepository;
import com.example.lab05_20206438.Repository.MascotaRepository;
import com.example.lab05_20206438.Repository.PersonaRepository;
import com.example.lab05_20206438.Repository.ViajeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    final
    ViajeRepository viajeRepository;
    final PersonaRepository personaRepository;
    final LugaresRepository lugaresRepository;
    final MascotaRepository mascotaRepository;

    public MascotaController(ViajeRepository viajeRepository,
                            PersonaRepository personaRepository,
                            LugaresRepository lugaresRepository,
                             MascotaRepository mascotaRepository) {
        this.viajeRepository = viajeRepository;
        this.personaRepository=personaRepository;
        this.lugaresRepository=lugaresRepository;
        this.mascotaRepository=mascotaRepository;
    }


    @GetMapping(value={"/lista",""})
    public String listaMascota(Model model){
        model.addAttribute("listaMascota",mascotaRepository.findAll());
        return "mascota/lista";
    }
    @GetMapping("/nuevaMascota")
    public String nuevaMascota(Model model){
        model.addAttribute("listaPersonas",personaRepository.findAll());
        model.addAttribute("listaLugares",lugaresRepository.findAll());
        return "mascota/nuevaMascota";
    }
    @PostMapping("/guardar")
    public String guardarNuevaMascota(Mascotas mascota){
        mascotaRepository.save(mascota);
        return "redirect:/mascota/lista";
    }
    @GetMapping("/editar")
    public String editarViaje(Model model,
                              @RequestParam("id") int id) {

        Optional<Viaje> optShipper = viajeRepository.findById(id);

        if (optShipper.isPresent()) {
            Viaje viajes = optShipper.get();
            model.addAttribute("viajes", viajes);
            model.addAttribute("listaPersonas",personaRepository.findAll());
            model.addAttribute("listaLugares",lugaresRepository.findAll());
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
        return "redirect:/viajes/lista";

    }
}
