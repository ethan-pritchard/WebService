package com.ethanpritchard.webservice.models.responses;

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
public class HelloWorldResponse {
    private String message;
}
