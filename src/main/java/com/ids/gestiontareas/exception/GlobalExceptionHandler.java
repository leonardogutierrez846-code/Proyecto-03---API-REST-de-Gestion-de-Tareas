package com.ids.gestiontareas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TareaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String manejarError(TareaNotFoundException ex) {
        return ex.getMessage();
    }
}