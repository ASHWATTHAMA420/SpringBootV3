package com.sample.excpetion;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.io.IOException;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(CustomException.class)
    public void CustomExceptionHandler(HttpServletResponse response, CustomException ex) throws IOException {
        response.sendError(ex.getHttpStatus().value(), ex.getMessage());
    }
    @ExceptionHandler(AccessDeniedException.class)
    public void AccessDeniedExceptionHandler(HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public void UsernameNotFoundExceptionHandler(HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
    }
    @ExceptionHandler(Exception.class)
    public void generalExceptionHandler(HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Something went wrong");
    }
}
