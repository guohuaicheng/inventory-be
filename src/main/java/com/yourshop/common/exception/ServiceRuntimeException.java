package com.yourshop.common.exception;

/**
 * @author G
 */
public class ServiceRuntimeException extends RuntimeException {
    private String errorCode;

    public ServiceRuntimeException() {
        super();
    }

    public ServiceRuntimeException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceRuntimeException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ServiceRuntimeException(Throwable cause) {
        super(cause);
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
