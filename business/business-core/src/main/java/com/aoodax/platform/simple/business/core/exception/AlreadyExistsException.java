package com.aoodax.platform.simple.business.core.exception;

public class AlreadyExistsException extends AoodaxException {
    public AlreadyExistsException() {
        this("Already exists");
    }

    public AlreadyExistsException(final String message) {
        super(message, null, false, false);
    }

    public AlreadyExistsException(final Throwable cause) {
        super(cause);
    }

    public AlreadyExistsException(final String message,
                                  final Throwable cause) {
        super(message, cause);
    }
}
