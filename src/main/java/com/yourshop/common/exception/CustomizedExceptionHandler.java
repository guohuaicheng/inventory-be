package com.yourshop.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author G
 */
@ControllerAdvice
public class CustomizedExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ExceptionResult handle(Exception e) {
        ExceptionResult result = new ExceptionResult();
        if(e instanceof ServiceRuntimeException) {
            result.setErrorCode(((ServiceRuntimeException) e).getErrorCode());
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
