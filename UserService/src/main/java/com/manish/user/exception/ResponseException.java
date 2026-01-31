package com.manish.user.exception;

import com.manish.user.dto.GeneralFailResponseDTO;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResponseException {
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<GeneralFailResponseDTO> handleApplicationException(@NonNull ApplicationException e){
        return new ResponseEntity<>(new GeneralFailResponseDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
