package com.aoodax.platform.simple.business.core.exception;

public class ValidationException extends AoodaxException {
    public ValidationException() {
        this("Validation Exception");
    }

    public ValidationException(final String message) {
        super(message, null, false, false);
    }

    public ValidationException(final Throwable cause) {
        super(cause);
    }

    public ValidationException(final String message,
                               final Throwable cause) {
        super(message, cause);
    }
}
