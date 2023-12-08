package com.ethanpritchard.webservice.models;

import com.ethanpritchard.webservice.DI;
import com.ethanpritchard.webservice.constants.LambdaProxyConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@With
public class LambdaProxyResponse<T> {
    private T body;
    private Map<String, String> headers = new HashMap<String, String>() {{
        putAll(LambdaProxyConstants.RESPONSE_HEADERS);
    }};
    private Boolean isBase64Encoded = false;
    private Integer statusCode = 200;

    public String getBody() {
        return DI.GSON.toJson(body);
    }
}
