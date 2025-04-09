package com.example.clase_lab1_sem3.Persona;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonController {
    @Autowired
    PersonaRepository personaRepository;

    @PostMapping
    ResponseEntity<Persona> createdPersona(@RequestBody Persona persona) {
        return ResponseEntity.ok(personaRepository.save(persona));
    }

    @GetMapping
    ResponseEntity<List<Persona>> getPersonas() {
        return ResponseEntity.ok(personaRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Persona> getPersona(@PathVariable Long id) {
        Optional<Persona> persona = personaRepository.findById(id);

        if(persona.isEmpty()) {
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(persona.get());
    }

    @GetMapping("/nombre/{nombre}")
    ResponseEntity<List<Persona>> getPersonaByNombre(@PathVariable String nombre) {
        List<Persona> personas = personaRepository.findByNombre(nombre);

        return ResponseEntity.ok(personas);
    }

    @GetMapping("/apellido/{apellido}")
    ResponseEntity<List<Persona>> getPersonaByApellido(@PathVariable String apellido) {
        List<Persona> personas = personaRepository.findByApellido(apellido);

        return ResponseEntity.ok(personas);
    }

}
