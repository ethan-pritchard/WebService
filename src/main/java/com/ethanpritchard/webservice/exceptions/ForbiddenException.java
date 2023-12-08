package com.ethanpritchard.webservice.exceptions;

public class ForbiddenException extends WebServiceException {
    private final Integer statusCode = 403;

    public ForbiddenException(final String message, final Throwable throwable, final Boolean external) {
        super(message, throwable, external);
    }

    public ForbiddenException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public ForbiddenException(final String message, final Boolean external) {
        super(message, external);
    }

    public ForbiddenException(final String message) {
        super(message);
    }
}
