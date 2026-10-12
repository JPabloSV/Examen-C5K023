package com.medtriage_backend.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(GeneralException.class)
    public ProblemDetail manejar(GeneralException exception) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                exception.getStatus(), exception.getMessage());
        problem.setTitle("Error en la solicitud");
        return problem;
    }
}
