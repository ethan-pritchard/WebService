package com.ethanpritchard.webservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@With
public class LambdaProxyError {
    private String errorMessage;
}
