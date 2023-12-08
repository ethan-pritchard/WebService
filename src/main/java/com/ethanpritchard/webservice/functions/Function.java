package com.ethanpritchard.webservice.functions;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.ethanpritchard.webservice.exceptions.BadRequestException;
import com.ethanpritchard.webservice.exceptions.ForbiddenException;
import com.ethanpritchard.webservice.exceptions.InternalServerException;
import com.ethanpritchard.webservice.exceptions.WebServiceException;
import com.ethanpritchard.webservice.models.LambdaProxyError;
import com.ethanpritchard.webservice.models.LambdaProxyRequest;
import com.ethanpritchard.webservice.models.LambdaProxyResponse;

import java.lang.reflect.ParameterizedType;

public abstract class Function<I, O> implements RequestHandler<LambdaProxyRequest<I>, LambdaProxyResponse<?>> {
    @Override
    public LambdaProxyResponse<?> handleRequest(final LambdaProxyRequest<I> request, final Context context) {
        try {
            final I requestBody = request.getBody((Class<I>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
            validateRequest(requestBody, context);
            return new LambdaProxyResponse<O>().withBody(processRequest(requestBody, context));
        } catch (Exception e) {
            final LambdaProxyError responseBody = new LambdaProxyError().withErrorMessage("Internal Server Exception (500)");
            final LambdaProxyResponse<LambdaProxyError> response = new LambdaProxyResponse<LambdaProxyError>()
                    .withBody(responseBody)
                    .withStatusCode(500);

            if (e instanceof WebServiceException && ((WebServiceException) e).getExternal()) {
                if (((WebServiceException) e).getExternal()) {
                    responseBody.setErrorMessage(e.getMessage());
                }

                if (e instanceof BadRequestException) {
                    response.setStatusCode(400);
                } else if (e instanceof ForbiddenException) {
                    response.setStatusCode(403);
                } else if (e instanceof InternalServerException) {
                    response.setStatusCode(500);
                }
            }

            return response;
        }
    }

    abstract O processRequest(final I request, final Context context) throws InternalServerException;
    abstract void validateRequest(final I request, final Context context) throws BadRequestException, ForbiddenException;
}
