package ua.edu.ukma.schedule.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.edu.ukma.schedule.exception.CustomException;
import ua.edu.ukma.schedule.exception.EntityNotFoundException;
import ua.edu.ukma.schedule.util.CustomResponse;
import ua.edu.ukma.schedule.util.CustomResponseError;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Log4j2
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public CustomResponse handle(Exception e) {
        return CustomResponse.of(new CustomResponseError(INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR.getReasonPhrase()));
    }

    @ExceptionHandler(CustomException.class)
    public CustomResponse handle(CustomException e) {
        return CustomResponse.of(new CustomResponseError(e.getCode(), e.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public CustomResponse handle(EntityNotFoundException e) {
        log.debug("Specific custom exception");
        return CustomResponse.of(new CustomResponseError(e.getCode(), e.getMessage()));
    }
}
