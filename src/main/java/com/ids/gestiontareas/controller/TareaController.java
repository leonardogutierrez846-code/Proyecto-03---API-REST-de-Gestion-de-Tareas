package com.ids.gestiontareas.controller;

import com.ids.gestiontareas.model.EstadoTarea;
import com.ids.gestiontareas.model.Tarea;
import com.ids.gestiontareas.service.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService service;

    public TareaController(TareaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarea> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Tarea obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<Tarea> crear(@RequestBody Tarea tarea) {
        return ResponseEntity.status(201).body(service.guardar(tarea));
    }

    @PutMapping("/{id}")
    public Tarea actualizar(@PathVariable Long id, @RequestBody Tarea tarea) {
        return service.actualizar(id, tarea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/estado/{estado}")
    public List<Tarea> filtrar(@PathVariable EstadoTarea estado) {
        return service.filtrarPorEstado(estado);
    }
}