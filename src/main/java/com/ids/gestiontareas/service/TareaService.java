package com.ids.gestiontareas.service;

import com.ids.gestiontareas.model.EstadoTarea;
import com.ids.gestiontareas.model.Tarea;

import java.util.List;

public interface TareaService {
    List<Tarea> listar();
    Tarea obtenerPorId(Long id);
    Tarea guardar(Tarea tarea);
    Tarea actualizar(Long id, Tarea tarea);
    void eliminar(Long id);
    List<Tarea> filtrarPorEstado(EstadoTarea estado);
}