package com.ethanpritchard.webservice.models;

import com.ethanpritchard.webservice.DI;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@With
public class LambdaProxyRequest<T> {
    @Getter(AccessLevel.NONE)
    private String body;
    private List<String> cookies;
    private Map<String, List<String>> headers;
    private Boolean isBase64Encoded;
    private Map<String, String> pathParameters;
    private Map<String, List<String>> queryStringParameters;
    private String rawPath;
    private String rawQueryString;
    private Object requestContext; //todo
    private String routeKey;
    private Map<String, String> stageVariables;
    private String version;

    public T getBody(final Class<T> tClass) {
        return DI.GSON.fromJson(this.body, tClass);
    }

    public void setHeaders(final Map<String, String> headers) {
        this.headers = Objects.isNull(headers) ? null : headers.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, x -> Arrays.asList(x.getValue().split(","))));
    }

    public void setQueryStringParameters(final Map<String, String> queryStringParameters) {
        this.queryStringParameters = Objects.isNull(queryStringParameters) ? null : queryStringParameters.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, x -> Arrays.asList(x.getValue().split(","))));
    }
}
