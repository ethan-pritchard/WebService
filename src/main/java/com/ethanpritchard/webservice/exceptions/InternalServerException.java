package com.ethanpritchard.webservice.exceptions;

public class InternalServerException extends WebServiceException {
    public InternalServerException(final String message, final Throwable throwable, final Boolean external) {
        super(message, throwable, external);
    }

    public InternalServerException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public InternalServerException(final String message, final Boolean external) {
        super(message, external);
    }

    public InternalServerException(final String message) {
        super(message);
    }
}
