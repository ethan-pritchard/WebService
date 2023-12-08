package com.ethanpritchard.webservice.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.ethanpritchard.webservice.exceptions.BadRequestException;
import com.ethanpritchard.webservice.models.requests.HelloWorldRequest;
import com.ethanpritchard.webservice.models.responses.HelloWorldResponse;
import com.ethanpritchard.webservice.utils.ValidationUtils;

public class HelloWorldFunction extends Function<HelloWorldRequest, HelloWorldResponse> {
    @Override
    public HelloWorldResponse processRequest(final HelloWorldRequest request, final Context context) {
        return new HelloWorldResponse().withMessage("hello, " + request.getName() + "!");
    }

    @Override
    public void validateRequest(final HelloWorldRequest request, final Context context) throws BadRequestException {
        ValidationUtils.validateNonNull(request.getName(), "name", true);
    }
}
