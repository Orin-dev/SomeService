package ru.yvzorin.someservice.port.adapter.webclient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yury Zorin
 */

@ControllerAdvice(annotations = RestController.class)
public class ErrorHandlingControllerAdvise {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> catchHippocratesApplicationException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
