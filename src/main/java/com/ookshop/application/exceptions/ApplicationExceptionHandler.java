package com.ookshop.application.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public com.ookshop.application.exceptions.ErrorDto handlerException(HttpServletRequest request, IllegalArgumentException e) {
        final String errorMessage = prepareMessage(request, e);
        log.error(errorMessage);
        return com.ookshop.application.exceptions.ErrorDto.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .path(request.getRequestURI())
                .timestamp(LocalDateTime.now())
                .build();
    }

    private String prepareMessage(HttpServletRequest request, IllegalArgumentException e) {
        return "Error while consuming " +
                request.getRequestURI() +
                ", exception message: " +
                e.getMessage() +
                "\n" +
                ExceptionUtils.getStackTrace(e);
    }

}
