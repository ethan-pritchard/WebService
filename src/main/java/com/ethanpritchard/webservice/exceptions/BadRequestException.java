package com.ethanpritchard.webservice.exceptions;

public class BadRequestException extends WebServiceException {
    public BadRequestException(final String message, final Throwable throwable, final Boolean external) {
        super(message, throwable, external);
    }

    public BadRequestException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public BadRequestException(final String message, final Boolean external) {
        super(message, external);
    }

    public BadRequestException(final String message) {
        super(message);
    }
}
