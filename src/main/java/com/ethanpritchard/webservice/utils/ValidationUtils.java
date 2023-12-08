package com.ethanpritchard.webservice.utils;

import com.ethanpritchard.webservice.exceptions.BadRequestException;

import java.util.Objects;

public class ValidationUtils {
    public static void validateNonNull(final Object input, final String name, final Boolean external) throws BadRequestException {
        if (Objects.isNull(input)) {
            throw new BadRequestException(String.format("'%s' is null.", name), external);
        }
    }
}
