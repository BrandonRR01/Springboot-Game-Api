package com.proyectos.game_service.commons.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class StackTraceError extends AbstractClass{

    private String className;

    private String method;

    private Integer lineNumber;
}
