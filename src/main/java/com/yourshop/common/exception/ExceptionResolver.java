package com.yourshop.common.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author G
 */
public class ExceptionResolver extends ExceptionHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response, HandlerMethod handlerMethod, Exception exception) {
        if (exception instanceof ServiceRuntimeException) {
            ServiceRuntimeException serviceRuntimeException = (ServiceRuntimeException) exception;
            try {
                response.getWriter().print("{'errorCode:'" + serviceRuntimeException.getErrorCode() + ", 'message:'" + serviceRuntimeException.getMessage() + "}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            response.getWriter().print("{'errorCode:0000', 'message:'" + exception.getMessage() + "}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
