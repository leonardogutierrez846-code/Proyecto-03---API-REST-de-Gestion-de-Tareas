package com.ids.gestiontareas.service;

import com.ids.gestiontareas.exception.TareaNotFoundException;
import com.ids.gestiontareas.model.EstadoTarea;
import com.ids.gestiontareas.model.Tarea;
import com.ids.gestiontareas.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

    private final TareaRepository repository;

    public TareaServiceImpl(TareaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tarea> listar() {
        return repository.findAll();
    }

    @Override
    public Tarea obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TareaNotFoundException("Tarea no encontrada"));
    }

    @Override
    public Tarea guardar(Tarea tarea) {
        return repository.save(tarea);
    }

    @Override
    public Tarea actualizar(Long id, Tarea tarea) {
        Tarea existente = obtenerPorId(id);
        existente.setTitulo(tarea.getTitulo());
        existente.setDescripcion(tarea.getDescripcion());
        existente.setEstado(tarea.getEstado());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Tarea tarea = obtenerPorId(id);
        repository.delete(tarea);
    }

    @Override
    public List<Tarea> filtrarPorEstado(EstadoTarea estado) {
        return repository.findByEstado(estado);
    }
}