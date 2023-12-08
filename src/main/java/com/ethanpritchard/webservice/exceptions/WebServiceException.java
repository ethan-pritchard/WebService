package com.ethanpritchard.webservice.exceptions;

import lombok.Getter;

@Getter
public class WebServiceException extends Exception {
    private final Boolean external;

    public WebServiceException(final String message, final Throwable throwable, final Boolean external) {
        super(message, throwable);
        this.external = external;
    }

    public WebServiceException(final String message, final Throwable throwable) {
        this(message, throwable, false);
    }

    public WebServiceException(final String message, final Boolean external) {
        this(message, null, external);
    }

    public WebServiceException(final String message) {
        this(message, null, false);
    }
}
