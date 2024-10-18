package com.proyectos.game_service.controller.impl;

import com.proyectos.game_service.commons.dto.ErrorResponse;
import com.proyectos.game_service.commons.exceptions.GameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(value = {GameException.class})
    ResponseEntity<ErrorResponse> handleGameError(GameException gameException){

        log.error("StackTraceError: {}, ", gameException.getStackTraceError(), gameException);

        ErrorResponse errorResponse = ErrorResponse.builder()
                .codeStatus(gameException.getHttpStatus().value())
                .message(gameException.getMessage())
                .build();

        return ResponseEntity.status(gameException.getHttpStatus()).body(errorResponse);
    }
}
