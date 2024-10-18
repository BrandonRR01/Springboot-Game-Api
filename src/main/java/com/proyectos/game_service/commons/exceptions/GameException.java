package com.proyectos.game_service.commons.exceptions;

import com.proyectos.game_service.commons.dto.StackTraceError;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GameException extends RuntimeException{

    private HttpStatus httpStatus;

    public GameException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public StackTraceError getStackTraceError(){

        StackTraceElement stackTraceElement = this.getStackTrace()[0];

        String className = stackTraceElement.getClassName();

        int lastIndex = className.lastIndexOf('.');

        return StackTraceError.builder()
                .className(className.substring(lastIndex + 1))
                .method(stackTraceElement.getMethodName())
                .lineNumber(stackTraceElement.getLineNumber())
                .build();

    }


}
