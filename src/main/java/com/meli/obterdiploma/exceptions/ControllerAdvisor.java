package com.meli.obterdiploma.exceptions;

import com.meli.obterdiploma.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<List<ErrorDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        List<ErrorDTO> errors = new ArrayList<>();
        for (FieldError fieldError: e.getBindingResult().getFieldErrors()) {
            errors.add(new ErrorDTO(fieldError.getField(), fieldError.getDefaultMessage()));
        }

        return new ResponseEntity<>(errors, httpStatus);
    }

}
