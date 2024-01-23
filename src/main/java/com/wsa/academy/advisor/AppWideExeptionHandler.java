package com.wsa.academy.advisor;

import com.wsa.academy.exception.NotFoundException;
import com.wsa.academy.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExeptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handlerNotFoundExeption(NotFoundException e) {
        ResponseEntity<StandardResponse> sResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(404, "Error", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
        return sResponse;
    }
}
