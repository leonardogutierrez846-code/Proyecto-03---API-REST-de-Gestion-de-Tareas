package com.ids.gestiontareas.repository;

import com.ids.gestiontareas.model.Tarea;
import com.ids.gestiontareas.model.EstadoTarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByEstado(EstadoTarea estado);
}