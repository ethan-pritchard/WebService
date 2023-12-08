package com.ethanpritchard.webservice.constants;

import java.util.HashMap;
import java.util.Map;

public class LambdaProxyConstants {
    public final static Map<String, String> RESPONSE_HEADERS = new HashMap<String, String>() {{
        put("content-type", "application/json");
    }};
}
