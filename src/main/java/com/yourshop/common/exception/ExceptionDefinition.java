package com.yourshop.common.exception;

import com.yourshop.common.constants.IConstants;
import com.yourshop.common.util.ContextUtil;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author G
 */

public enum ExceptionDefinition {

    LOGIN_ERROR("a.000000");

    private String errorCode;
    ExceptionDefinition(String errorCode) {
        this.errorCode = errorCode;
    }

//    ResourceBundle resourceBundle = ResourceBundle.getBundle(IConstants.EXCEPTION_MESSAGE, Locale.getDefault());

    private String getMessage(Object... args) {
//        String message = resourceBundle.getString(this.errorCode);
        String message = ContextUtil.getMessage(this.errorCode, null, this.name(), Locale.getDefault());
        return MessageFormat.format(message, args);
    }

    public ServiceRuntimeException exception(Object... args) {
        return new ServiceRuntimeException(this.errorCode, getMessage(args));
    }

    public ServiceRuntimeException exception(Throwable cause, Object... args) {
        return new ServiceRuntimeException(this.errorCode, getMessage(args), cause);
    }
}
