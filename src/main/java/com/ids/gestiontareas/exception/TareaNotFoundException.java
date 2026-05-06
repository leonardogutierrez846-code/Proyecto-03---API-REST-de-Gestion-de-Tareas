package com.ids.gestiontareas.exception;

public class TareaNotFoundException extends RuntimeException {
    public TareaNotFoundException(String mensaje) {
        super(mensaje);
    }
}